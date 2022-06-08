package uz.customs.customsprice.service.earxiv;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.earxiv.Earxiv;
import uz.customs.customsprice.payload.EarxivSearchResponse;
import uz.customs.customsprice.repository.EarxivRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EarxivService {
    private final EarxivRepo earxivRepo;

    @PersistenceContext(unitName = "earxiv")
    private EntityManager entityManagerFactoryEarxiv;

    public EarxivService(EarxivRepo earxivRepo) {
        this.earxivRepo = earxivRepo;
    }

    public List<Earxiv> getAll(String id) {
        if (earxivRepo.findAll() != null) {
            return earxivRepo.findAll();
        } else return null;
    }

    public Earxiv save(Earxiv earxiv) {
        return earxivRepo.save(earxiv);
    }

    public Earxiv create(Earxiv earxiv) {
        return earxivRepo.save(earxiv);
    }


    public List<EarxivSearchResponse> getFile(String fileId) {
        String queryForList = "select\n" +
                "    f.folder_id,\n" +
                "    f.name,\n" +
                "    f.user_inn,\n" +
                "    f.user_pnfl,\n" +
                "    fd.docname,\n" +
                "    fd.doc_type,\n" +
                "    dt.cd_nm doc_type_name,\n" +
                "    fd.file_id,\n" +
                "    fd.status,\n" +
                "    dt.cd_nm,\n" +
                "    fd.hash\n" +
                "from\n" +
                "    e_arxiv.folder f\n" +
                "join\n" +
                "    e_arxiv.file_type fl\n" +
                "on\n" +
                "    f.folder_id=fl.folder_id\n" +
                "and fl.isdeleted=0\n" +
                "join\n" +
                "    e_arxiv.freedoc fd\n" +
                "on\n" +
                "    fl.file_id=fd.file_id\n" +
                "and fd.isdeleted=0\n" +
                "join\n" +
                "    e_arxiv.docs_type dt\n" +
                "on\n" +
                "    dt.code=fd.doc_type\n" +
                "and dt.lnga_tpcd='UZ'\n" +
                "and fd.isdeleted=0\n" +
                "and\n" +
                "    (\n" +
                "        fd.status=2\n" +
                "    or  fd.status=1\n" +
                "    or  fd.status=0)\n" +
                "where\n" +
                "    f.isdeleted=0\n" +
                "    and fl.FILE_ID='" + fileId + "'\n";
        return (List<EarxivSearchResponse>) entityManagerFactoryEarxiv.createNativeQuery(queryForList).getResultList();
    }


    public List<Object[]> getFile1(String fileId) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User authUser = (User) authentication.getPrincipal();
        String queryForList = "select\n" +
                "    f.folder_id,\n" +
                "    f.name,\n" +
                "    f.user_inn,\n" +
                "    f.user_pnfl,\n" +
                "    fd.docname,\n" +
                "    fd.doc_type,\n" +
                "    fd.file_id,\n" +
                "    fd.status,\n" +
                "    dt.cd_nm,\n" +
                "    fd.hash,\n" +
                "    fl.file_num\n" +
                "from\n" +
                "    e_arxiv.folder f\n" +
                "join\n" +
                "    e_arxiv.file_type fl\n" +
                "on\n" +
                "    f.folder_id=fl.folder_id\n" +
                "and fl.isdeleted=0\n" +
                "join\n" +
                "    e_arxiv.freedoc fd\n" +
                "on\n" +
                "    fl.file_id=fd.file_id\n" +
                "and fd.isdeleted=0\n" +
                "join\n" +
                "    e_arxiv.docs_type dt\n" +
                "on\n" +
                "    dt.code=fd.doc_type\n" +
                "and dt.lnga_tpcd='UZ'\n" +
                "and fd.isdeleted=0\n" +
                "and (\n" +
                "        fd.status=2\n" +
                "    or  fd.status=1\n" +
                "    or  fd.status=0)\n" +
                "where\n" +
                "    f.isdeleted=0\n" +
                "    and fl.FILE_ID='" + fileId + "'\n";
        List<Object[]> resultList = entityManagerFactoryEarxiv.createNativeQuery(queryForList).getResultList();
        return resultList;
    }

    public List<Earxiv> getByAppId(String appId) {
        if (earxivRepo.findByAppId(appId) != null) {
            return earxivRepo.findByAppId(appId);
        } else return null;
    }

    public Earxiv getByHashAndFileId(String hash, String fileId) {
        if (earxivRepo.findByHashAndFileId(hash, fileId) != null) {
            return earxivRepo.findByHashAndFileId(hash, fileId);
        } else return null;
    }

}
