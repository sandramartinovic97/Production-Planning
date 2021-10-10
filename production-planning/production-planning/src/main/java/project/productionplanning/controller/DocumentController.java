package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.productionplanning.dto.DocumentDto;
import project.productionplanning.service.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<DocumentDto> getDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public DocumentDto getDocumentById(@PathVariable("id") Integer id) {
        return documentService.getDocumentById(id);
    }

    @PostMapping
    public void addDocument(@RequestBody DocumentDto documentDto){
        documentService.addDocument(documentDto);
    }

    @PutMapping("/{id}")
    public void updateDocument(@RequestBody DocumentDto documentDto, @PathVariable("id") Integer id){
        documentService.updateDocument(documentDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable("id") Integer id) {
        documentService.deleteDocument(id);
    }
}
