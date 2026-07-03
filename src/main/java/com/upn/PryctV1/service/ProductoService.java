package com.upn.PryctV1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upn.PryctV1.dto.ProductoDTO;
import com.upn.PryctV1.model.ProductoModel;
import com.upn.PryctV1.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    // Convertir de Model a DTO
    public ProductoDTO convertirDTO(ProductoModel p) {
        ProductoDTO dto = new ProductoDTO();
        dto.setCodProducto(p.getCodProducto());
        dto.setNomMarca(p.getNomMarca());
        dto.setPrecio(p.getPrecio());
        dto.setTamano(p.getTamano());
        return dto;
    }

    // Listar todos los productos
    public List<ProductoDTO> listar() {
        List<ProductoModel> lista = repository.findAll();
        return lista.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public ProductoModel getProducto(int id) {
        ProductoModel p = repository.findById(id).orElse(null);
        return p;
    }

    // Guardar
    public ProductoModel saveProducto(ProductoModel p) {
        return repository.save(p);
    }

    // Eliminar
    public void deleteProducto(int id) {
        repository.deleteById(id);
    }

    // Buscar por nombre (JPQL)
    public List<ProductoDTO> buscarPorNombreJPQL(String nomMarca) {
        List<ProductoModel> lista = repository.buscarPorNombreJPQL(nomMarca);
        return lista.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // Buscar por nombre (SQL Nativo)
    public List<ProductoDTO> buscarPorNombreSQL(String nomMarca) {
        List<ProductoModel> lista = repository.buscarPorNombreSQL(nomMarca);
        return lista.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

}