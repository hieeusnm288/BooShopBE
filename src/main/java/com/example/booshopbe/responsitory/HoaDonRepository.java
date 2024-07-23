package com.example.booshopbe.responsitory;

import com.example.booshopbe.dto.DoanhThuDTO;
import com.example.booshopbe.dto.DoanhThuProjection;
import com.example.booshopbe.dto.HoaDonDTO;
import com.example.booshopbe.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    List<HoaDon> findByKhachHang_IdKhachHang(UUID idKhachHang);
    @Query(" WITH Thang AS (\n" +
            "    SELECT 1 AS Thang\n" +
            "    UNION ALL\n" +
            "    SELECT 2\n" +
            "    UNION ALL\n" +
            "    SELECT 3\n" +
            "    UNION ALL\n" +
            "    SELECT 4\n" +
            "    UNION ALL\n" +
            "    SELECT 5\n" +
            "    UNION ALL\n" +
            "    SELECT 6\n" +
            "    UNION ALL\n" +
            "    SELECT 7\n" +
            "    UNION ALL\n" +
            "    SELECT 8\n" +
            "    UNION ALL\n" +
            "    SELECT 9\n" +
            "    UNION ALL\n" +
            "    SELECT 10\n" +
            "    UNION ALL\n" +
            "    SELECT 11\n" +
            "    UNION ALL\n" +
            "    SELECT 12\n" +
            ")\n" +
            "SELECT \n" +
            "    t.Thang as thang,\n" +
            "    ISNULL(SUM(hd.tongtien), 0) AS doanhthu\n" +
            "FROM \n" +
            "    Thang t\n" +
//            "WHERE hd.trangThaiHoaDon.IdTrangThaiHoaDon = 7 \n"+
            "LEFT JOIN \n" +
            "    HoaDon hd ON MONTH(hd.ngaytao) = t.Thang AND YEAR(hd.ngaytao) = 2024\n" +
            "AND hd.trangThaiHoaDon.idTrangThaiHoaDon = 6 " +
            "GROUP BY \n" +
            "    t.Thang\n" +
            "ORDER BY \n" +
            "    t.Thang")
    List<DoanhThuProjection> findMonthlyRevenueWithStatus();


    @Query(value = "SELECT COUNT(*) " +
            "FROM HoaDon hd " +
            "WHERE YEAR(hd.ngaytao) = 2024 " +
            "AND hd.TrangThaiHoaDon = 6", nativeQuery = true)
    int findTongSoHoaDonHoanThanhTheoNam();

    @Query(value = "SELECT COUNT(*) " +
            "FROM HoaDon hd " +
            "WHERE YEAR(hd.ngaytao) = 2024 "
            , nativeQuery = true)
    int findTongSoHoaDonTheoNam();

    Page<HoaDon> findByKhachHang_UsernameContainsIgnoreCase(String username, Pageable pageable);

    Page<HoaDon> findByTrangThaiHoaDon_IdTrangThaiHoaDon(int IdTrangThaiHoaDon, Pageable pageable);

    Page<HoaDon> findByKhachHang_UsernameContainsIgnoreCaseAndTrangThaiHoaDon_IdTrangThaiHoaDon(String username, int idTrangThaiHoaDon, Pageable pageable);






}
