package ejemplo;

import ejemplo.entidades.*;
import ejemplo.repositorios.InMemoryRepository;
import ejemplo.eje2.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Empresa> empresaRepository = new InMemoryRepository<>();


        System.out.println("Crear Pais");
        Pais pais = Pais.builder()
                .nombre("Argentina")
                .build();
        System.out.println(pais);

        System.out.println("-------------");
        System.out.println("Crear Provincia");
        Provincia provincia = Provincia.builder()
                .nombre("Buenos Aires")
                .pais(pais)
                .build();
        System.out.println(provincia);

        System.out.println("-------------");
        System.out.println("Crear Localidad BsAs");
        Localidad localidad1 = Localidad.builder()
                .nombre("CABA")
                .provincia(provincia)
                .build();
        System.out.println(localidad1);

        System.out.println("----------");
        System.out.println("Crear Domicilio para CABA");
        Domicilio domicilio1= Domicilio.builder()
                .calle("Calle 13")
                .numero(13)
                .cp(5539)
                .localidad(localidad1)
                .build();
        System.out.println(domicilio1);

        System.out.println("-------------");
        System.out.println("Crear Localidad BsAs");
        Localidad localidad2 = Localidad.builder()
                .nombre("La Plata")
                .provincia(provincia)
                .build();
        System.out.println(localidad2);

        System.out.println("----------");
        System.out.println("Crear Domicilio para La Plata");
        Domicilio domicilio2= Domicilio.builder()
                .calle("Calle 6")
                .numero(6)
                .cp(5204)
                .localidad(localidad2)
                .build();
        System.out.println(domicilio2);

        System.out.println("-------------");
        System.out.println("Crear Provincia CORDOBA");
        Provincia provincia2 = Provincia.builder()
                .nombre("Cordoba")
                .pais(pais)
                .build();
        System.out.println(provincia2);

        System.out.println("-------------");
        System.out.println("Crear Localidad Cordoba");
        Localidad localidad3 = Localidad.builder()
                .nombre("Cordoba Capital")
                .provincia(provincia2)
                .build();
        System.out.println(localidad3);

        System.out.println("----------");
        System.out.println("Crear Domicilio Cordoba Capital");
        Domicilio domicilio3= Domicilio.builder()
                .calle("Calle 8")
                .numero(8)
                .cp(7000)
                .localidad(localidad3)
                .build();
        System.out.println(domicilio3);

        System.out.println("-------------");
        System.out.println("Crear Localidad Cordoba");
        Localidad localidad4 = Localidad.builder()
                .nombre("Villa Carlos Paz")
                .provincia(provincia2)
                .build();
        System.out.println(localidad4);

        System.out.println("----------");
        System.out.println("Crear Domicilio Villa Carlos Paz");
        Domicilio domicilio4= Domicilio.builder()
                .calle("Calle 9")
                .numero(9)
                .cp(5555)
                .localidad(localidad4)
                .build();
        System.out.println(domicilio4);

        System.out.println("-------");
        System.out.println("Sucursal1 ");
        Sucursal sucursal1= Sucursal.builder()
                .id (1L)
                .nombre("Sucursal 1")
                .horarioApertura(LocalTime.of (9,0))
                .horarioCierre(LocalTime.of (18,0))
                .es_Casa_Matriz(true)
                .domicilio(domicilio1)
                .build();
        System.out.println(sucursal1);

        System.out.println("-------");
        System.out.println("Sucursal2 ");
        Sucursal sucursal2= Sucursal.builder()
                .id (2L)
                .nombre("Sucursal 2")
                .horarioApertura(LocalTime.of (9,0))
                .horarioCierre(LocalTime.of (18,30))
                .es_Casa_Matriz(true)
                .domicilio(domicilio2)
                .build();
        System.out.println(sucursal2);

        System.out.println("-------");
        System.out.println("Sucursal3 ");
        Sucursal sucursal3= Sucursal.builder()
                .id (3L)
                .nombre("Sucursal 3")
                .horarioApertura(LocalTime.of (10,0))
                .horarioCierre(LocalTime.of (20,30))
                .es_Casa_Matriz(false)
                .domicilio(domicilio3)
                .build();
        System.out.println(sucursal3);

        System.out.println("-------");
        System.out.println("Sucursal 4 ");
        Sucursal sucursal4= Sucursal.builder()
                .id (4L)
                .nombre("Sucursal 4")
                .horarioApertura(LocalTime.of (7,0))
                .horarioCierre(LocalTime.of (15,30))
                .es_Casa_Matriz(false)
                .domicilio(domicilio4)
                .build();
        System.out.println(sucursal4);

        System.out.println("---------");
        System.out.println("Crear empresa 1");
        Empresa empresa1 = Empresa.builder()
                .nombre("Empresa 1")
                .cuit(4562)
                .logo("Logo1")
                .razonSocial("Razon Social1")
                .sucursal (new HashSet<>(Set.of(sucursal1, sucursal2)))
                .build();
        System.out.println(empresa1);

        System.out.println("---------");
        System.out.println("Crear empresa 2");
        Empresa empresa2 = Empresa.builder()
                .nombre("Empresa 2")
                .cuit(45465421)
                .logo("Logo2")
                .razonSocial("Razon Social 2")
                .sucursal (new HashSet<>(Set.of(sucursal3, sucursal4)))
                .build();
        System.out.println(empresa1);

        sucursal1.setEmpresa(empresa1);
        sucursal2.setEmpresa(empresa1);
        sucursal3.setEmpresa(empresa2);
        sucursal4.setEmpresa(empresa2);

        empresaRepository.save(empresa1);
        empresaRepository.save(empresa2);

        //muestra todas las empresas
        System.out.println("Todas las empresas");
        List <Empresa> todaslasempresas=empresaRepository.findAll();
        todaslasempresas.forEach(System.out::println);
        //buscar por id
        System.out.println("Buscar por Id");
        Optional <Empresa> EmpresaEncontrada = empresaRepository.findById(1L);
        EmpresaEncontrada.ifPresent(e -> System.out.println("empresa encontrada por ID 1: " + e));
        //buscar por nombre
        System.out.println("Buscar por Nombre");
        List <Empresa> EmpresaPorNombre = empresaRepository.genericFindByField("nombre","Empresa 1");
        System.out.println("Empresa con nombre 'Empresa 1': ");
        EmpresaPorNombre.forEach(System.out::println);
        //actualizar empresa
        System.out.println("Actualizar empresa por ID");
        Empresa empresaActualizada = Empresa.builder()
                .id(1L)
                .nombre("Empresa 1 actualizada")
                .razonSocial("Razon social 1.0")
                .cuit (4562)
                .sucursal(empresa1.getSucursal())
                .build();
        empresaRepository.genericUpdate(1l,empresaActualizada);
        Optional<Empresa> EmpresaVerificada= empresaRepository.findById(1L);
        EmpresaVerificada.ifPresent(e -> System.out.println("empresa Actualizada  " + e));

        //eliminar una empresa por id
        System.out.println("Eliminar empresa");
        empresaRepository.genericDelete(1L);
        Optional<Empresa> EmpresaEliminada= empresaRepository.findById(1L);
        if (EmpresaEliminada.isEmpty()) {
            System.out.println("La empresa con ID1 ha sido eliminada");
        }
        //empresas restantes
        System.out.println("empresas restantes");
        List <Empresa> empresaRestante = empresaRepository.findAll();
        empresaRestante.forEach(System.out::println);


        System.out.println("\n========== PRUEBAS DE STOCK POR SUCURSAL ==========\n");
        // Crear artículos e insumos

        InMemoryRepository<Categoria> categoriaRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> articuloInsumoRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> articuloManufacturadoRepository = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepository = new InMemoryRepository<>();
        InMemoryRepository<Imagen> imagenInMemoryRepository = new InMemoryRepository<>();

        //creo categorias y guardo
        System.out.println("----------LAS CATEGORIAS SON:");
        Categoria pizzas = Categoria.builder().denominacion("Pizzas").build();
        Categoria Sandwich = Categoria.builder().denominacion("Sandwich").build();
        Categoria Lomos = Categoria.builder().denominacion("Lomos").build();
        Categoria Insumos = Categoria.builder().denominacion("Insumos").build();

        categoriaRepository.save(pizzas);categoriaRepository.save(Sandwich);categoriaRepository.save(Lomos);categoriaRepository.save(Insumos);


        System.out.println(pizzas);System.out.println(Sandwich);System.out.println(Lomos);System.out.println(Insumos);

        System.out.println("----------LAS UNIDADES DE MEDIDA SON:");
        //creo unidad de medida
        UnidadMedida Kilogramos = UnidadMedida.builder().denominacion("Kilogramos").build();
        UnidadMedida Litros = UnidadMedida.builder().denominacion("Litros").build();
        UnidadMedida Gramos = UnidadMedida.builder().denominacion("Gramos").build();

        unidadMedidaRepository.save (Kilogramos);unidadMedidaRepository.save (Litros);unidadMedidaRepository.save (Gramos);

        System.out.println(Kilogramos); System.out.println(Litros);System.out.println(Gramos);


        //crear Articulos
        System.out.println("----------LOS INSUMOS SON:");
        ArticuloInsumo Sal =ArticuloInsumo.builder().denominacion("Sal").precioCompra(1.0).stockActual(100).stockMinimo(10)
                .stockMaximo(200).esParaElaborar(true).unidadMedida(Gramos).categoria(Insumos).build();
        ArticuloInsumo Aceite =ArticuloInsumo.builder() .denominacion("Aceite")  .precioCompra(0.5) .stockActual(100)
                .stockMinimo(15)   .stockMaximo(150)  .esParaElaborar(true) .unidadMedida(Litros)
                .categoria(Insumos)                .build();
        ArticuloInsumo Carne =ArticuloInsumo.builder()
                .denominacion("Carne").precioCompra(7.0).stockActual(40).stockMinimo(7)
                .stockMaximo(60).esParaElaborar(true).unidadMedida(Kilogramos).categoria(Insumos).build();
        ArticuloInsumo Harina =ArticuloInsumo.builder().denominacion("Harina")
                .precioCompra(0.25).stockActual(200).stockMinimo(100).stockMaximo(220)
                .esParaElaborar(true).unidadMedida(Kilogramos).categoria(Insumos).build();

        articuloInsumoRepository.save (Sal);articuloInsumoRepository.save (Aceite);articuloInsumoRepository.save (Carne);articuloInsumoRepository.save (Harina);

        System.out.println(Sal); System.out.println(Aceite); System.out.println(Carne);System.out.println(Harina);


        Imagen imagen1= Imagen.builder().denominacion("PizzaHawaiana1").build ();
        Imagen imagen2= Imagen.builder().denominacion("PizzaHawaiana2").build ();
        Imagen imagen3= Imagen.builder().denominacion("PizzaHawaiana3").build ();
        Imagen imagen4= Imagen.builder().denominacion("LomoCompletoLomo1").build ();
        Imagen imagen5= Imagen.builder().denominacion("LomoCompletoLomo2").build ();
        Imagen imagen6= Imagen.builder().denominacion("LomoCompletoLomo3").build ();

        imagenInMemoryRepository.save (imagen1);
        imagenInMemoryRepository.save (imagen2);
        imagenInMemoryRepository.save (imagen3);
        imagenInMemoryRepository.save (imagen4);
        imagenInMemoryRepository.save (imagen5);
        imagenInMemoryRepository.save (imagen6);

        ArticuloManufacturadoDetalle detallePizzaHawaina1= ArticuloManufacturadoDetalle.builder()
                .id(1L)
                .cantidad(20)
                .articuloInsumo (Sal)
                .build ();
        ArticuloManufacturadoDetalle detallePizzaHawaina2= ArticuloManufacturadoDetalle.builder()
                .id(2L)
                .cantidad(10)
                .articuloInsumo (Harina)
                .build ();
        ArticuloManufacturadoDetalle detallePizzaHawaina3= ArticuloManufacturadoDetalle.builder()
                .id(3L)
                .cantidad(15)
                .articuloInsumo (Aceite)
                .build ();
        ArticuloManufacturadoDetalle detalleLomoCompleto1= ArticuloManufacturadoDetalle.builder()
                .id(4L)
                .cantidad(20)
                .articuloInsumo (Sal)
                .build ();
        ArticuloManufacturadoDetalle detalleLomoCompleto2= ArticuloManufacturadoDetalle.builder()
                .id(5L)
                .cantidad(10)
                .articuloInsumo (Aceite)
                .build ();
        ArticuloManufacturadoDetalle detalleLomoCompleto3= ArticuloManufacturadoDetalle.builder()
                .id(6L)
                .cantidad(20)
                .articuloInsumo (Harina)
                .build ();

        ArticuloManufacturado PizzaHawaiana= ArticuloManufacturado.builder()
                .denominacion("Pizza Hawaina")
                .precioVenta(12000.0)
                .descripcion("Pizza con piña y jamón")
                .tiempoEstimadoMinutos(15)
                .preparacion("Hornear por 20 minutos")
                .categoria(pizzas)
                .unidadMedida(Kilogramos)
                .imagen(new HashSet<>(Set.of(imagen1, imagen2, imagen3)))
                .ArticuloDetalle(new HashSet<>(Set.of(detallePizzaHawaina1, detallePizzaHawaina2, detallePizzaHawaina3)))
                .build();
        ArticuloManufacturado LomoCompleto= ArticuloManufacturado.builder()
                .denominacion("Lomo Completo")
                .precioVenta(15000.0)
                .descripcion("Lomo completo con ingredientes")
                .tiempoEstimadoMinutos(20)
                .preparacion("Hornear por 30 minutos")
                .categoria(Lomos)
                .unidadMedida(Kilogramos)
                .imagen(new HashSet<>(Set.of(imagen4, imagen5, imagen6)))
                .ArticuloDetalle(new HashSet<>(Set.of(detalleLomoCompleto1, detalleLomoCompleto2, detalleLomoCompleto3)))
                .build();

        articuloManufacturadoRepository.save (PizzaHawaiana);
        articuloManufacturadoRepository.save (LomoCompleto);

        // Agregar artículos a sucursal1
        sucursal1.getArticulosManufacturados().add(PizzaHawaiana);
        sucursal1.getArticulosManufacturados().add(LomoCompleto);

        // Si querés, también podés agregarlos a sucursal2
        sucursal2.getArticulosManufacturados().add(PizzaHawaiana);
        sucursal2.getArticulosManufacturados().add(LomoCompleto);

        sucursal3.getArticulosManufacturados().add(PizzaHawaiana);
        sucursal3.getArticulosManufacturados().add(LomoCompleto);

        sucursal4.getArticulosManufacturados().add(PizzaHawaiana);
        sucursal4.getArticulosManufacturados().add(LomoCompleto);

        System.out.println("ARTICULOS DE CADA SUCURSAL");

        System.out.println("Artículos de Sucursal 1:");
        sucursal1.getArticulosManufacturados().forEach(System.out::println);

        System.out.println("Artículos de Sucursal 2:");
        sucursal2.getArticulosManufacturados().forEach(System.out::println);

        System.out.println("Artículos de Sucursal 3:");
        sucursal3.getArticulosManufacturados().forEach(System.out::println);

        System.out.println("Artículos de Sucursal 4:");
        sucursal4.getArticulosManufacturados().forEach(System.out::println);


    }
}
