# CourierSync-QA

```bash
/CourierSync-QA/
│
├── test_cases/
│   ├── HU002_facturacion/
│   │   ├── TC005_factura_multiples_items.md   
│   │   ├── TC006_prevencion_duplicados.md    
│   └── HU003_edicion_factura/
│       └── TC009_validacion_concurrencia.md
│       └── TC010_cambios_version.md   
│
├── automation/
│   ├── api/
│   │   ├── test_facturacion.py                
│   │   └── test_edicion_factura.py
│   └── reports/
│       └── resultados.html
│
└── config/
    └── .env   ← URL del backend, credenciales de prueba
```
