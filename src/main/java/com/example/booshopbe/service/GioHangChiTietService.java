package com.example.booshopbe.service;

import com.example.booshopbe.apirespone.GlobalExceoption;
import com.example.booshopbe.dto.ChiTietGioHangDTO;
import com.example.booshopbe.entity.ChiTietSanPham;
import com.example.booshopbe.entity.GioHang;
import com.example.booshopbe.entity.GioHangChiTiet;
import com.example.booshopbe.responsitory.ChiTietSanPhamReposotory;
import com.example.booshopbe.responsitory.GioHangChiTietRepository;
import com.example.booshopbe.responsitory.GioHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangChiTietService {
    @Autowired
    GioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    GioHangRepository gioHangRepository;

    @Autowired
    ChiTietSanPhamReposotory chiTietSanPhamReposotory;

    public List<GioHangChiTiet> getListByGioHang(UUID id) {
        return gioHangChiTietRepository.findByGioHang_IdGioHang(id);
    }

    public GioHangChiTiet addSP(ChiTietGioHangDTO chiTietGioHangDTO) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamReposotory.findById(chiTietGioHangDTO.getIdChiTietSanPham()).get();
        GioHang gioHang = gioHangRepository.findById(chiTietGioHangDTO.getIdGioHang()).get();
        GioHangChiTiet gioHangCT = gioHangChiTietRepository.findByGioHang_IdGioHangAndChiTietSanPham_idChiTietSanPham(chiTietGioHangDTO.getIdGioHang(), chiTietGioHangDTO.getIdChiTietSanPham());
        if (gioHangCT == null) {
            if (chiTietSanPham.getSoluongton() < chiTietGioHangDTO.getSoluong()){
                throw new RuntimeException("Số lượng sản phẩm không đủ");
            }
            if (chiTietGioHangDTO.getSoluong() > 10){
                throw new RuntimeException("Số lượng không quá 10");
            }
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setGioHang(gioHang);
            gioHangChiTiet.setChiTietSanPham(chiTietSanPham);
            gioHangChiTiet.setSoluong(chiTietGioHangDTO.getSoluong());
            gioHangChiTiet.setTongtien(chiTietSanPham.getDongia());
            return gioHangChiTietRepository.save(gioHangChiTiet);
        } else {
            if (gioHangCT.getSoluong() + chiTietGioHangDTO.getSoluong() > 10){
                throw new RuntimeException("Số lượng không quá 10");
            }
            if (chiTietSanPham.getSoluongton() < gioHangCT.getSoluong() + chiTietGioHangDTO.getSoluong()){
                throw new RuntimeException("Số lượng sản phẩm không đủ");
            }
            if (chiTietGioHangDTO.getSoluong() < 1){
                throw new RuntimeException("Số lượng mua không thể là 0");
            }
            gioHangCT.setSoluong(gioHangCT.getSoluong() + chiTietGioHangDTO.getSoluong());
            gioHangCT.setTongtien(gioHangCT.getTongtien() + chiTietSanPham.getDongia());
            return gioHangChiTietRepository.save(gioHangCT);
        }
    }

    public void deleteSP(UUID uuid) {
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findById(uuid).get();
        gioHangChiTietRepository.deleteById(uuid);

    }

    public GioHangChiTiet update(UUID id , ChiTietGioHangDTO chiTietGioHangDTO){
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findById(id).get();
        ChiTietSanPham chiTietSanPham = chiTietSanPhamReposotory.findById(chiTietGioHangDTO.getIdChiTietSanPham()).get();
        if (gioHangChiTiet.getSoluong() + chiTietGioHangDTO.getSoluong() > 10){
            throw new RuntimeException("Số lượng không quá 10");
        }
        if (chiTietSanPham.getSoluongton() < gioHangChiTiet.getSoluong() + chiTietGioHangDTO.getSoluong()){
            throw new RuntimeException("Số lượng sản phẩm không đủ");
        }
        gioHangChiTiet.setSoluong(chiTietGioHangDTO.getSoluong());
        if (gioHangChiTiet.getSoluong() < chiTietGioHangDTO.getSoluong()){
            gioHangChiTiet.setTongtien(gioHangChiTiet.getTongtien() + chiTietSanPham.getDongia());
        }
        if (gioHangChiTiet.getSoluong() > chiTietGioHangDTO.getSoluong()){
            gioHangChiTiet.setTongtien(gioHangChiTiet.getTongtien() - chiTietSanPham.getDongia());
        }
        if (chiTietGioHangDTO.getSoluong() < 1){
            throw new RuntimeException("Số lượng mua không thể là 0");
        }

        return gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Transactional
    public void deleteAll(UUID id) {
        gioHangChiTietRepository.deleteByGioHang_IdGioHang(id);
    }
}
