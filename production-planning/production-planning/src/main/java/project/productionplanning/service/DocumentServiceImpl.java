package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.productionplanning.dto.DocumentDto;
import project.productionplanning.model.Document;
import project.productionplanning.repository.DocumentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DocumentDto> getAllDocuments() {
        List<Document> documents = documentRepository.findAll();
        List<DocumentDto> documentDtos = new ArrayList<>();
        for (Document document : documents) {
            DocumentDto documentDto = modelMapper.map(document, DocumentDto.class);
            documentDtos.add(documentDto);
        }
        return documentDtos;
    }

    @Override
    public DocumentDto getDocumentById(Integer id) {
        Document document = documentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find document with id = " + id));
        return modelMapper.map(document, DocumentDto.class);
    }

    @Override
    public DocumentDto addDocument(DocumentDto documentDto) {
        Document document = modelMapper.map(documentDto, Document.class);
        documentRepository.save(document);
        return modelMapper.map(document, DocumentDto.class);
    }

    @Override
    public DocumentDto updateDocument(DocumentDto documentDto, Integer id) {
        Document updatedDocument = modelMapper.map(documentDto, Document.class);
        Document documentFromDB = documentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find document with specified id = " + id));
        documentFromDB.setProductId(updatedDocument.getProductId());
        documentFromDB.setUserId(updatedDocument.getUserId());
        documentFromDB.setMachineId(updatedDocument.getMachineId());
        return modelMapper.map(documentRepository.save(documentFromDB), DocumentDto.class);
    }

    @Override
    public void deleteDocument(Integer id) {
        jdbcTemplate.execute("delete from material where document_id = " + id);
        documentRepository.deleteById(id);
    }
}
