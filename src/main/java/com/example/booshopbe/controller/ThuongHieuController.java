package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.ThuongHieuDTO;
import com.example.booshopbe.entity.ThuongHieu;
import com.example.booshopbe.service.FileStorageService;
import com.example.booshopbe.service.ThuongHieuService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/thuonghieu")
public class ThuongHieuController {
    @Autowired
    ThuongHieuService thuongHieuService;

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/logo/{fileName:.+}")
    public ResponseEntity<?> loadFile(@PathVariable String fileName, HttpServletRequest httpServletRequest) {
        Resource resource = fileStorageService.loadLogoFileAsResource(fileName);
        String contentTye = null;
        try {
            contentTye = httpServletRequest.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception ex) {
            throw new RuntimeException("FIle Not Fould", ex);
        }
        if (contentTye == null) {
            contentTye = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentTye)).header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""
                + resource.getFilename() + "\"").body(resource);
    }

    @PostMapping("/add")
    public ApiRespone<ThuongHieu> insert(@ModelAttribute ThuongHieuDTO dto){
        ThuongHieu entity = thuongHieuService.insert(dto);
        dto.setIdThuongHieu(entity.getIdThuongHieu());
        dto.setTenthuonghieu(entity.getTenthuonghieu());
        dto.setMota(entity.getMota());
        dto.setHinhanh(entity.getHinhanh());
        dto.setTrangthai(dto.getTrangthai());
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(dto);
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/all")
    public ApiRespone<List> getAll(){
        ApiRespone<List> apiRespone = new ApiRespone();
        apiRespone.setCode(200);
        apiRespone.setResult(thuongHieuService.getAll());
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/{id}")
    public ApiRespone<ThuongHieu> getThuongHieu(@PathVariable("id")UUID id){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thuongHieuService.findById(id));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @DeleteMapping("/{id}")
    public ApiRespone<?> delete(@PathVariable("id")UUID id){
        ApiRespone apiRespone = new ApiRespone();
        thuongHieuService.deleteThuongHieu(id);
        apiRespone.setResult("Xóa Thành công");
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PutMapping(value = "/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiRespone<?> updateBrand(@PathVariable("id") UUID id, @ModelAttribute ThuongHieuDTO brandDTO) {
        ApiRespone apiRespone = new ApiRespone();
        ThuongHieu updatedBrand = thuongHieuService.update(id,brandDTO);
        ThuongHieuDTO updatedBrandDTO = new ThuongHieuDTO();
        updatedBrandDTO.setIdThuongHieu(updatedBrand.getIdThuongHieu());
        updatedBrandDTO.setTenthuonghieu(updatedBrand.getTenthuonghieu());
        updatedBrandDTO.setHinhanh(updatedBrand.getHinhanh());
        updatedBrandDTO.setMota(updatedBrand.getMota());
        updatedBrandDTO.setTrangthai(updatedBrand.getTrangthai());
        apiRespone.setCode(200);
        apiRespone.setResult(updatedBrandDTO);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

}
