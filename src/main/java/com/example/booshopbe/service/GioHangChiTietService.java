package com.example.booshopbe.service;

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
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setGioHang(gioHang);
            gioHangChiTiet.setChiTietSanPham(chiTietSanPham);
            gioHangChiTiet.setSoluong(1);
            gioHangChiTiet.setTongtien(chiTietSanPham.getDongia());
            return gioHangChiTietRepository.save(gioHangChiTiet);
        } else {
            gioHangCT.setSoluong(gioHangCT.getSoluong() + 1);
            gioHangCT.setTongtien(gioHangCT.getTongtien() + chiTietSanPham.getDongia());
            int sl = chiTietSanPham.getSoluongton() - 1;
            chiTietSanPham.setSoluongton(sl);
            chiTietSanPhamReposotory.save(chiTietSanPham);
            return gioHangChiTietRepository.save(gioHangCT);
        }
    }

    public void deleteSP(UUID uuid) {
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findById(uuid).get();
        gioHangChiTietRepository.deleteById(uuid);
        ChiTietSanPham chiTietSanPham = chiTietSanPhamReposotory.findById(gioHangChiTiet.getChiTietSanPham().getIdChiTietSanPham()).get();
        chiTietSanPham.setSoluongton(chiTietSanPham.getSoluongton() + gioHangChiTiet.getSoluong());
        chiTietSanPham.setIdChiTietSanPham(gioHangChiTiet.getChiTietSanPham().getIdChiTietSanPham());
        chiTietSanPhamReposotory.save(chiTietSanPham);
    }

    @Transactional
    public void deleteAll(UUID id) {
        gioHangChiTietRepository.deleteByGioHang_IdGioHang(id);
    }
}
