package com.glow.business.web.rest;

import com.glow.business.service.BusinessService;
import com.glow.business.service.dto.BusinessDTO;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api/businesses")
public class BusinessResource {

    private final BusinessService businessService;

    public BusinessResource(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping
    public ResponseEntity<BusinessDTO> createBusiness(@Valid @RequestBody BusinessDTO businessDTO) throws URISyntaxException {
        if (businessDTO.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        BusinessDTO result = businessService.save(businessDTO);
        return ResponseEntity.created(new URI("/api/businesses/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessDTO> updateBusiness(
        @PathVariable Long id,
        @Valid @RequestBody BusinessDTO businessDTO
    ) {
        if (businessDTO.getId() == null || !id.equals(businessDTO.getId())) {
            return ResponseEntity.badRequest().build();
        }
        BusinessDTO result = businessService.save(businessDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<BusinessDTO>> getAllBusinesses(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        Page<BusinessDTO> page = businessService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessDTO> getBusiness(@PathVariable Long id) {
        return ResponseUtil.wrapOrNotFound(businessService.findOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusiness(@PathVariable Long id) {
        businessService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
