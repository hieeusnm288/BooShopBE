package com.example.booshopbe.responsitory;

import com.example.booshopbe.dto.ChiTietSanPhamDTO;
import com.example.booshopbe.dto.ChiTietSanPhamProjection;
import com.example.booshopbe.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietSanPhamReposotory extends JpaRepository<ChiTietSanPham, UUID> {
    @Query("\tSELECT p.idChiTietSanPham as idChiTietSanPham, p.degiay as degiay,p.mausac as mausac, p.kichco as kichco, p.trangthai as trangthai,p.dongia as dongia, p.soluongton as soluongton,\n" +
            "\t\t   d.tenhinhanh as tenhinhanh\n" +
            "\tFROM ChiTietSanPham p\n" +
            "\tINNER JOIN HinhAnh d ON p.idChiTietSanPham = d.chitietsanpham.idChiTietSanPham\n" +
            "\twhere p.sanpham.idSanPham = ?1")
    List<ChiTietSanPhamProjection> findBySanpham_IdSanPham(UUID idSanPham);

    public ChiTietSanPham findBySanpham_IdSanPhamAndKichco_IdKichCoAndMausac_IdMauSac(UUID idSanPham, UUID idKichCo, UUID idMauSac);

//    Optional<ChiTietSanPham> findBySanpham_IdSanPhamAndKichco_IdKichCoAndMausac_IdMauSac(UUID idSanPham, UUID idKichCo, UUID idMauSac);

//    @Query("\tSELECT p.idChiTietSanPham as idChiTietSanPham, p.degiay as degiay,p.mausac as mausac, p.kichco as kichco, p.trangthai as trangthai,p.dongia as dongia, p.soluongton as soluongton,\n" +
//            "\t\t   d.tenhinhanh as tenhinhanh\n" +
//            "\tFROM ChiTietSanPham p\n" +
//            "\tINNER JOIN HinhAnh d ON p.idChiTietSanPham = d.chitietsanpham.idChiTietSanPham\n" +
//            "\twhere p.sanpham.idSanPham = ?1 and p.kichco.idKichCo =?2 and p.mausac.idMauSac = ?3")
//    List<ChiTietSanPhamProjection> findBySanpham_IdSanPham_IdKichCo_IdMauSac(UUID idSanPham, UUID idKichCo, UUID idMauSac);
}
