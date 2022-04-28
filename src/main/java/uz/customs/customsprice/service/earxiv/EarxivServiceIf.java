package uz.customs.customsprice.service.earxiv;

import uz.customs.customsprice.entity.earxiv.Earxiv;

import java.util.List;

public interface EarxivServiceIf {
    Earxiv create(Earxiv earxiv);

    Earxiv update(String id, Earxiv earxiv);

    List<Object[]> getFile(String fileId);
}
