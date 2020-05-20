package addvertisment.controller;

import addvertisment.model.Brand;
import addvertisment.model.Comment;
import addvertisment.model.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/brand")
public class BrandController {

    @GetMapping("")
    public ResponseEntity<?> getAllBrands()  { return null; }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleBrand(@PathVariable Long id)  {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<?> createBrand (@RequestBody Brand brand)  {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrand (@RequestBody Brand brand, @PathVariable Long id) {
        return null;
    }

    //ako se obrise brend treba da se obrisu i svi njegovi modeli
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand (@PathVariable Long id) {
        return null;
    }

    @GetMapping("/{brand_id}/model")
    public ResponseEntity<?> getAllModels()  {
        return null;
    }

    @GetMapping("/{brand_id}/model/{model_id}")
    public ResponseEntity<?> getSingleModel(@PathVariable Long id)  {
        return null;
    }

    @PostMapping("/{brand_id}/model")
    public ResponseEntity<?> createModel (@RequestBody Model model)  {
        return null;
    }

    @PutMapping("/{brand_id}/model/{model_id}")
    public ResponseEntity<?> updateModel (@RequestBody Model model, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{brand_id}/model/{model_id}")
    public ResponseEntity<?> deleteModel (@PathVariable Long id) {
        return null;
    }
}
