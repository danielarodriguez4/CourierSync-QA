package com.tuempresa.facturacion.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class FacturaServiceTest {

    private final FacturaService facturaService = new FacturaService();

    // Caso de excepción: lista vacía (no hay ítems). Este cubre la rama de decisión negativa del método.
    @Test
    void testGenerarFacturaSinItems() {
        List<Item> items = List.of();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            facturaService.generarFactura(items);
        });
        assertEquals("Error: sin ítems", ex.getMessage());
    }

    //Caso feliz: factura válida sin descuento. Subtotal <= 500000 - no aplica descuento
    void testGenerarFacturaSinDescuento() {
        List<Item> items = List.of(
                new Item("Producto A", 2, 100000)
        );
        Factura factura = facturaService.generarFactura(items);
        assertEquals(200000, factura.getSubtotal());
        assertEquals(200000, factura.getTotal());
    }

    //Caso feliz alterno: factura válida con descuento. Subtotal > 500000 - aplica 10% de descuento
    @Test
    void testGenerarFacturaConDescuento() {
        List<Item> items = List.of(
                new Item("Producto A", 6, 100000)
        );
        Factura factura = facturaService.generarFactura(items);
        assertEquals(600000, factura.getSubtotal());
        assertEquals(540000, factura.getTotal());
    }
}
