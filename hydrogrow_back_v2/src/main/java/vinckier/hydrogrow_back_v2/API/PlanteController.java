package vinckier.hydrogrow_back_v2.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import vinckier.hydrogrow_back_v2.bdd.models.Plante;
import vinckier.hydrogrow_back_v2.dao.service.PlanteDAO;

@RestController
@RequestMapping("/api/plante")
public class PlanteController {

    private final PlanteDAO planteDAO;

    @Autowired
    public PlanteController(PlanteDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    @GetMapping("/{id}")
    public Plante findById(@PathVariable("id") Long id) {
        return planteDAO.findById(id);
    }

    @GetMapping("/")
    public List<Plante> findAll() {
        return planteDAO.findAll();
    }

    @PostMapping("/")
    public void save(@RequestBody Plante plante) {
        planteDAO.save(plante);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Plante plante, @PathVariable("id") Long id) {
        Plante planteToUpdate = planteDAO.findById(id);
        if (planteToUpdate != null) {
            planteToUpdate.setNomPlante(plante.getNomPlante());
            planteToUpdate.setTypePlante(plante.getTypePlante());
            planteToUpdate.setDescription(plante.getDescription());
            planteToUpdate.setBoutureMin(plante.getBoutureMin());
            planteToUpdate.setBoutureMax(plante.getBoutureMax());
            planteToUpdate.setPousseMin(plante.getPousseMin());
            planteToUpdate.setPousseMax(plante.getPousseMax());
            planteToUpdate.setHumiditeMin(plante.getHumiditeMin());
            planteToUpdate.setHumiditeMax(plante.getHumiditeMax());
            planteToUpdate.setTemperatureMin(plante.getTemperatureMin());
            planteToUpdate.setTemperatureMax(plante.getTemperatureMax());
            planteToUpdate.setLumiere(plante.getLumiere());
            planteToUpdate.setExpositionMin(plante.getExpositionMin());
            planteToUpdate.setExpositionMax(plante.getExpositionMax());
            planteDAO.update(planteToUpdate);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Plante planteToDelete = planteDAO.findById(id);
        if (planteToDelete != null) {
            planteDAO.delete(planteToDelete);
        }
    }
}
