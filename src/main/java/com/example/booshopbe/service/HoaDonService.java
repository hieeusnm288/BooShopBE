package com.example.booshopbe.service;

import com.example.booshopbe.apirespone.GlobalExceoption;
import com.example.booshopbe.dto.HoaDonDTO;
import com.example.booshopbe.entity.*;
import com.example.booshopbe.responsitory.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    KhachHangResponsitory khachHangResponsitory;

    @Autowired
    TrangThaiHoaDonRepository trangThaiHoaDonRepository;

    @Autowired
    HinhThucThanhToanRespository hinhThucThanhToanRespository;

    @Autowired
    KhuyenMaiResponsitory khuyenMaiResponsitory;

    @Autowired
    ChiTietHoaDonRepository chiTietHoaDonRepository;

    @Autowired
    ChiTietSanPhamReposotory chiTietSanPhamReposotory;

    public Page<HoaDon> getAll(String username, int idTrangThaiHoaOon, Pageable pageable) {
        if (username != null && !username.isEmpty() && idTrangThaiHoaOon == 0){
           return hoaDonRepository.findByKhachHang_UsernameContainsIgnoreCase(username,pageable);
        }else if(idTrangThaiHoaOon != 0 && username.isEmpty()){
            return hoaDonRepository.findByTrangThaiHoaDon_IdTrangThaiHoaDon(idTrangThaiHoaOon,pageable);
        }else if(username != null && !username.isEmpty() && idTrangThaiHoaOon != 0){
            return hoaDonRepository.findByKhachHang_UsernameContainsIgnoreCaseAndTrangThaiHoaDon_IdTrangThaiHoaDon(username, idTrangThaiHoaOon,pageable);
        }else {
            return hoaDonRepository.findAll(pageable);
        }
    }

    public List<HoaDon> getByKhachHang(UUID id) {
        return hoaDonRepository.findByKhachHang_IdKhachHang(id);
    }

    public HoaDon insert(HoaDonDTO hoaDonDTO){
        HoaDon entity = new HoaDon();
        Date date = new Date();

        KhachHang khachHang = khachHangResponsitory.findById(hoaDonDTO.getIdKhachHang()).get();
        if (hoaDonDTO.getIdKhuyenMai() != null){
            UUID uuid = UUID.fromString(hoaDonDTO.getIdKhuyenMai());
            KhuyenMai khuyenMai = khuyenMaiResponsitory.findById(uuid).get();
            entity.setKhuyenMai(khuyenMai);
            khuyenMai.setSoluong(khuyenMai.getSoluong() -1);
            khuyenMaiResponsitory.save(khuyenMai);
        }else {
            entity.setKhuyenMai(null);
        }
        TrangThaiHoaDon trangThaiHoaDon = trangThaiHoaDonRepository.findById(hoaDonDTO.getIdTrangThaiDonHang()).get();
        PhuongThucThanhToan phuongThucThanhToan = hinhThucThanhToanRespository.findById(hoaDonDTO.getIdPhuongThucThanhToan()).get();
        BeanUtils.copyProperties(hoaDonDTO, entity);
        entity.setNgaytao(date);
        entity.setKhachHang(khachHang);
        entity.setTrangThaiHoaDon(trangThaiHoaDon);
        entity.setPhuongThucThanhToan(phuongThucThanhToan);
        return hoaDonRepository.save(entity);
    }

    public HoaDon update(UUID id, HoaDonDTO hoaDonDTO){
        HoaDon entity = hoaDonRepository.findById(id).get();
        if (entity == null){
            throw new GlobalExceoption("Khong tim thay san pham");
        }
        List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonRepository.findByHoaDon_IdHoaDon(id);
        TrangThaiHoaDon trangThaiHoaDon = trangThaiHoaDonRepository.findById(hoaDonDTO.getIdTrangThaiDonHang()).get();
        if (entity.getTrangThaiHoaDon().getIdTrangThaiHoaDon() > hoaDonDTO.getIdTrangThaiDonHang()){
            throw new GlobalExceoption("Không thể cập nhật lùi");
        }
        if (entity.getTrangThaiHoaDon().getIdTrangThaiHoaDon() + 1 < hoaDonDTO.getIdTrangThaiDonHang() && hoaDonDTO.getIdTrangThaiDonHang() != 7){
            throw new GlobalExceoption("Không thể cập cập nhật");
        }
        if (entity.getTrangThaiHoaDon().getIdTrangThaiHoaDon() != 1 && hoaDonDTO.getIdTrangThaiDonHang() == 7){
            throw new GlobalExceoption("Không thể cập cập nhật");
        }
        if (trangThaiHoaDon.getIdTrangThaiHoaDon() == 2){
            for (ChiTietHoaDon cthd : chiTietHoaDons){

                ChiTietSanPham chiTietSanPham = chiTietSanPhamReposotory.findById(cthd.getChiTietSanPham().getIdChiTietSanPham()).get();
                if (chiTietSanPham.getSoluongton() < cthd.getSoluong()){
                    throw new RuntimeException("Số lượng không đủ");
                }else {
                    chiTietSanPham.setSoluongton(chiTietSanPham.getSoluongton() - cthd.getSoluong());
                    chiTietSanPhamReposotory.save(chiTietSanPham);
                }
            }
        }

        entity.setTrangThaiHoaDon(trangThaiHoaDon);
        return hoaDonRepository.save(entity);
    }
}
