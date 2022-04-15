package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Packaging;
import uz.customs.customsprice.repository.PackagingRepo;

@Service
public class PackagingService {
    private final PackagingRepo packagingRepo;

    public PackagingService(PackagingRepo packagingRepo) {
        this.packagingRepo = packagingRepo;
    }

    public Packaging getByIdAndLngaTpcd(String code, String lngaTpcd) {
        return packagingRepo.findByCodeAndLngaTpcd(code, lngaTpcd);

    }
}
