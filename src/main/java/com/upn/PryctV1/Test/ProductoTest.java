package com.upn.PryctV1.Test;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.upn.PryctV1.ProyectoGasApplication;
import com.upn.PryctV1.dto.ProductoDTO;
import com.upn.PryctV1.model.ProductoModel;
import com.upn.PryctV1.service.ProductoService;
 
public class ProductoTest {

    public static void main(String[] args) {

    	ApplicationContext context = new SpringApplicationBuilder(ProyectoGasApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        ProductoService service = context.getBean(ProductoService.class);

        System.out.println();
        System.out.println("===== LISTADO INICIAL =====");
        listar(service);

        // Insertar productos
        ProductoModel p1 = new ProductoModel();
        p1.setNomMarca("Gloria");
        p1.setPrecio(4.50);
        p1.setTamano("1 Litro");
        service.saveProducto(p1);

        ProductoModel p2 = new ProductoModel();
        p2.setNomMarca("Laive");
        p2.setPrecio(4.80);
        p2.setTamano("1 Litro");
        service.saveProducto(p2);

        ProductoModel p3 = new ProductoModel();
        p3.setNomMarca("Nestlé");
        p3.setPrecio(5.20);
        p3.setTamano("500 ml");
        service.saveProducto(p3);

        System.out.println();
        System.out.println("===== LISTADO DESPUÉS DE INSERTAR =====");
        listar(service);

        // Modificar un producto
        ProductoModel productoModificar = service.getProducto(p1.getCodProducto());

        if (productoModificar != null) {
            productoModificar.setNomMarca("Gloria Premium");
            productoModificar.setPrecio(5.00);
            service.saveProducto(productoModificar);
        }

        System.out.println();
        System.out.println("===== LISTADO DESPUÉS DE MODIFICAR =====");
        listar(service);

        // Eliminar un producto
        service.deleteProducto(p2.getCodProducto());

        System.out.println();
        System.out.println("===== LISTADO DESPUÉS DE ELIMINAR =====");
        listar(service);

        // Búsqueda JPQL
        System.out.println();
        System.out.println("===== BÚSQUEDA JPQL POR NOMBRE =====");

        List<ProductoDTO> resultadoJPQL = service.buscarPorNombreJPQL("Gloria");

        for (ProductoDTO dto : resultadoJPQL) {
            imprimir(dto);
        }

        // Búsqueda SQL
        System.out.println();
        System.out.println("===== BÚSQUEDA SQL POR NOMBRE =====");

        List<ProductoDTO> resultadoSQL = service.buscarPorNombreSQL("Nestlé");

        for (ProductoDTO dto : resultadoSQL) {
            imprimir(dto);
        }

        System.exit(0);
    }

    private static void listar(ProductoService service) {
        List<ProductoDTO> lista = service.listar();

        for (ProductoDTO dto : lista) {
            imprimir(dto);
        }
    }

    private static void imprimir(ProductoDTO dto) {

        System.out.println(
                dto.getCodProducto() + " - " +
                dto.getNomMarca() + " - " +
                dto.getPrecio() + " - " +
                dto.getTamano()
        );

    }

}