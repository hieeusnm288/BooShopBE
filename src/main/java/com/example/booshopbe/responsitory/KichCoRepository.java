package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.KichCo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KichCoRepository extends JpaRepository<KichCo, UUID> {
    KichCo findByTenkichco(String tenkichco);

}
