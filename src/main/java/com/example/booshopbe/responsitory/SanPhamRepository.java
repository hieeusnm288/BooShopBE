package com.example.booshopbe.responsitory;

import com.example.booshopbe.dto.SanPhamProjection;
import com.example.booshopbe.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    @Query("SELECT p.idSanPham as idSanPham, p.tensanpham as tensanpham,p.thuonghieu as thuonghieu , p.trangthai as trangthai, p.mota as mota," +
            " d.idChiTietSanPham as idChiTietSanPham, d.kichco as kichco, d.mausac as mausac, d.degiay as degiay, d.soluongton as soluongton, d.dongia as dongia, i.tenhinhanh as tenhinhanh" +
            " FROM SanPham p" +
            " INNER JOIN ChiTietSanPham d ON p.idSanPham = d.sanpham.idSanPham" +
            " LEFT JOIN HinhAnh i ON d.idChiTietSanPham = i.chitietsanpham.idChiTietSanPham" +
            " WHERE d.idChiTietSanPham IN (" +
            "   SELECT MIN(idChiTietSanPham)" +
            "   FROM ChiTietSanPham" +
            "   GROUP BY sanpham.idSanPham" +
            " )")
    Page<SanPhamProjection> getList(Pageable pageable);

    @Query("SELECT p.idSanPham as idSanPham, p.tensanpham as tensanpham, p.thuonghieu as thuonghieu , p.trangthai as trangthai, p.mota as mota," +
            "       d.idChiTietSanPham as idChiTietSanPham, d.kichco as kichco, d.mausac as mausac, d.degiay as degiay, d.soluongton as soluongton, d.dongia as dongia, i.tenhinhanh as tenhinhanh" +
            " FROM SanPham p" +
            " INNER JOIN ChiTietSanPham d ON p.idSanPham = d.sanpham.idSanPham" +
            " LEFT JOIN HinhAnh i ON d.idChiTietSanPham = i.chitietsanpham.idChiTietSanPham" +
            " WHERE d.idChiTietSanPham = (" +
            "   SELECT MIN(cts.idChiTietSanPham) " +
            "   FROM ChiTietSanPham cts " +
            "   WHERE cts.sanpham.idSanPham = p.idSanPham" +
            " ) AND p.tensanpham like %?1% AND p.trangthai =?2 AND p.thuonghieu.idThuongHieu = ?3 ")

    List<SanPhamProjection> getListTenTTTH(String tensanpham, int trangthai, String id);

    @Query("SELECT p.idSanPham as idSanPham, p.tensanpham as tensanpham, p.thuonghieu as thuonghieu , p.trangthai as trangthai, p.mota as mota," +
            "       d.idChiTietSanPham as idChiTietSanPham, d.kichco as kichco, d.mausac as mausac, d.degiay as degiay, d.soluongton as soluongton, d.dongia as dongia, i.tenhinhanh as tenhinhanh" +
            " FROM SanPham p" +
            " INNER JOIN ChiTietSanPham d ON p.idSanPham = d.sanpham.idSanPham" +
            " LEFT JOIN HinhAnh i ON d.idChiTietSanPham = i.chitietsanpham.idChiTietSanPham" +
            " WHERE d.idChiTietSanPham = (" +
            "   SELECT MIN(cts.idChiTietSanPham) " +
            "   FROM ChiTietSanPham cts " +
            "   WHERE cts.sanpham.idSanPham = p.idSanPham" +
            " ) AND p.tensanpham like %?1%  ")
    Page<SanPhamProjection> getListByTen(String name,Pageable pageable);

    @Query("SELECT p.idSanPham as idSanPham, p.tensanpham as tensanpham, p.thuonghieu as thuonghieu , p.trangthai as trangthai, p.mota as mota," +
            "       d.idChiTietSanPham as idChiTietSanPham, d.kichco as kichco, d.mausac as mausac, d.degiay as degiay, d.soluongton as soluongton, d.dongia as dongia, i.tenhinhanh as tenhinhanh" +
            " FROM SanPham p" +
            " INNER JOIN ChiTietSanPham d ON p.idSanPham = d.sanpham.idSanPham" +
            " LEFT JOIN HinhAnh i ON d.idChiTietSanPham = i.chitietsanpham.idChiTietSanPham" +
            " WHERE d.idChiTietSanPham = (" +
            "   SELECT MIN(cts.idChiTietSanPham) " +
            "   FROM ChiTietSanPham cts " +
            "   WHERE cts.sanpham.idSanPham = p.idSanPham" +
            " ) AND p.thuonghieu.idThuongHieu = ?1  ")

    Page<SanPhamProjection> getListByBrand(UUID idThuongHieu, Pageable pageable);

    @Query("SELECT p.idSanPham as idSanPham, p.tensanpham as tensanpham, p.thuonghieu as thuonghieu , p.trangthai as trangthai, p.mota as mota," +
            "       d.idChiTietSanPham as idChiTietSanPham, d.kichco as kichco, d.mausac as mausac, d.degiay as degiay, d.soluongton as soluongton, d.dongia as dongia, i.tenhinhanh as tenhinhanh" +
            " FROM SanPham p" +
            " INNER JOIN ChiTietSanPham d ON p.idSanPham = d.sanpham.idSanPham" +
            " LEFT JOIN HinhAnh i ON d.idChiTietSanPham = i.chitietsanpham.idChiTietSanPham" +
            " WHERE d.idChiTietSanPham = (" +
            "   SELECT MIN(cts.idChiTietSanPham) " +
            "   FROM ChiTietSanPham cts " +
            "   WHERE cts.sanpham.idSanPham = p.idSanPham" +
            " ) AND p.trangthai = ?1  ")

    Page<SanPhamProjection> getListByStatus(int trangthai, Pageable pageable);

    @Query("SELECT p.idSanPham as idSanPham, p.tensanpham as tensanpham, p.thuonghieu as thuonghieu , p.trangthai as trangthai, p.mota as mota," +
            "       d.idChiTietSanPham as idChiTietSanPham, d.kichco as kichco, d.mausac as mausac, d.degiay as degiay, d.soluongton as soluongton, d.dongia as dongia, i.tenhinhanh as tenhinhanh" +
            " FROM SanPham p" +
            " INNER JOIN ChiTietSanPham d ON p.idSanPham = d.sanpham.idSanPham" +
            " LEFT JOIN HinhAnh i ON d.idChiTietSanPham = i.chitietsanpham.idChiTietSanPham" +
            " WHERE d.idChiTietSanPham = (" +
            "   SELECT MIN(cts.idChiTietSanPham) " +
            "   FROM ChiTietSanPham cts " +
            "   WHERE cts.sanpham.idSanPham = p.idSanPham" +
            " ) AND p.trangthai = ?1 AND p.tensanpham like %?2% ")

    List<SanPhamProjection> getListByStatusAndName(int trangthai, String name);

    @Query("SELECT p.idSanPham as idSanPham, p.tensanpham as tensanpham, p.thuonghieu as thuonghieu , p.trangthai as trangthai, p.mota as mota," +
            "       d.idChiTietSanPham as idChiTietSanPham, d.kichco as kichco, d.mausac as mausac, d.degiay as degiay, d.soluongton as soluongton, d.dongia as dongia, i.tenhinhanh as tenhinhanh" +
            " FROM SanPham p" +
            " INNER JOIN ChiTietSanPham d ON p.idSanPham = d.sanpham.idSanPham" +
            " LEFT JOIN HinhAnh i ON d.idChiTietSanPham = i.chitietsanpham.idChiTietSanPham" +
            " WHERE d.idChiTietSanPham = (" +
            "   SELECT MIN(cts.idChiTietSanPham) " +
            "   FROM ChiTietSanPham cts " +
            "   WHERE cts.sanpham.idSanPham = p.idSanPham" +
            " ) AND p.trangthai = ?1 AND p.thuonghieu.idThuongHieu = ?2 ")

    List<SanPhamProjection> getListByStatusAndName(int trangthai, UUID brand);

    @Query("SELECT p.idSanPham as idSanPham, p.tensanpham as tensanpham, p.thuonghieu as thuonghieu , p.trangthai as trangthai, p.mota as mota," +
            "       d.idChiTietSanPham as idChiTietSanPham, d.kichco as kichco, d.mausac as mausac, d.degiay as degiay, d.soluongton as soluongton, d.dongia as dongia, i.tenhinhanh as tenhinhanh" +
            " FROM SanPham p" +
            " INNER JOIN ChiTietSanPham d ON p.idSanPham = d.sanpham.idSanPham" +
            " LEFT JOIN HinhAnh i ON d.idChiTietSanPham = i.chitietsanpham.idChiTietSanPham" +
            " WHERE d.idChiTietSanPham = (" +
            "   SELECT MIN(cts.idChiTietSanPham) " +
            "   FROM ChiTietSanPham cts " +
            "   WHERE cts.sanpham.idSanPham = p.idSanPham" +
            " ) AND p.tensanpham like %?1% AND p.thuonghieu.idThuongHieu = ?2 ")
    List<SanPhamProjection> getListByBrandAndName(String name, UUID brand);


    @Query(value = "SELECT TOP 5 sp.tensanpham AS tensanpham, ha.tenhinhanh AS hinhanh, SUM(cthd.soluong) AS soLuongBanRa, kc.tenkichco AS kichco, ms.tenmausac AS mausac " +
            "FROM ChiTietHoaDon cthd " +
            "JOIN HoaDon hd ON cthd.hoaDonId = hd.idHoaDon " +
            "JOIN ChiTietSanPham ctsp ON cthd.chiTietSanPhamId = ctsp.idChiTietSanPham " +
            "JOIN SanPham sp ON ctsp.sanPhamId = sp.idSanPham " +
            "JOIN HinhAnh ha ON ctsp.idChiTietSanPham = ha.chiTietSanPhamId " +
            "JOIN KichCo kc ON ctsp.kichCoId = kc.idKichCo " +
            "JOIN MauSac ms ON ctsp.mauSacId = ms.idMauSac " +
            "WHERE MONTH(hd.ngaytao) = :month AND YEAR(hd.ngaytao) = :year " +
            "GROUP BY sp.tensanpham, ha.tenhinhanh, kc.tenkichco, ms.tenmausac " +
            "ORDER BY soLuongBanRa DESC", nativeQuery = true)
    List<Object[]> findBestSellingProducts(int month, int year);

    @Query(value = "SELECT TOP 5 sp.tensanpham AS tensanpham, ha.tenhinhanh AS hinhanh, ctsp.soLuongTon AS soLuongTon, kc.tenkichco AS kichco, ms.tenmausac AS mausac " +
            "FROM ChiTietSanPham ctsp " +
            "JOIN SanPham sp ON ctsp.sanPhamId = sp.idSanPham " +
            "JOIN HinhAnh ha ON ctsp.idChiTietSanPham = ha.chiTietSanPhamId " +
            "JOIN KichCo kc ON ctsp.kichCoId = kc.idKichCo " +
            "JOIN MauSac ms ON ctsp.mauSacId = ms.idMauSac " +
            "WHERE ctsp.soLuongTon <= 10" +
            "ORDER BY ctsp.soLuongTon ASC", nativeQuery = true)
    List<Object[]> findNearlyOutOfStockProducts();
}
