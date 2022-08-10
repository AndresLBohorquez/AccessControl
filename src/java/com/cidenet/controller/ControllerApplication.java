/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
mensajes = "Swal.fire('Bien hecho!','Usuario registrado correctamente','success')";
 */
package com.cidenet.controller;

import com.cidenet.entity.Area;
import com.cidenet.entity.Estado;
import com.cidenet.entity.Paisempleo;
import com.cidenet.entity.TipoIdentificacion;
import com.cidenet.entity.Usuario;
import com.cidenet.facade.AreaFacadeLocal;
import com.cidenet.facade.EstadoFacadeLocal;
import com.cidenet.facade.PaisempleoFacadeLocal;
import com.cidenet.facade.TipoIdentificacionFacadeLocal;
import com.cidenet.facade.UsuarioFacadeLocal;

import com.cidenet.util.FechaHora;
import com.cidenet.util.Letras;
import com.cidenet.util.Redireccionar;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author DarkJack
 */
@Named(value = "controllerApplication")
@ApplicationScoped
public class ControllerApplication {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    @EJB
    PaisempleoFacadeLocal paisempleoFacadeLocal;

    @EJB
    TipoIdentificacionFacadeLocal tipoIdentificacionFacadeLocal;

    @EJB
    EstadoFacadeLocal estadoFacadeLocal;

    @EJB
    AreaFacadeLocal areaFacadeLocal;

    //Arreglos
    private List<Usuario> listaUsuario = new ArrayList<>();
    private List<Paisempleo> listaPais = new ArrayList<>();
    private List<TipoIdentificacion> listaTipoId = new ArrayList<>();
    private List<Estado> listaEstado = new ArrayList<>();
    private List<Area> listaArea = new ArrayList<>();
    private List<String> listaCorreos = new ArrayList<>();

    //Variables
    private String mensajes;
    private String primerApellido = "";
    private String segundoApellido = "";
    private String primerNombre = "";
    private String otrosNombres = "";
    private String numeroIdentificacion = "";
    private String fechaIngreso = "";
    private Integer paisEmpleo = null;
    private Integer tipoIdentificacion = null;
    private Integer area = null;
    final Integer ESTADO = 1;
    private String correo;
    private String nombreSel;
    private String apellidoSel;

    //Objetos
    FechaHora fh = new FechaHora();
    Letras lt = new Letras();
    private Usuario usuSel = new Usuario();
    Redireccionar redir = new Redireccionar();

    public ControllerApplication() {
    }

    @PostConstruct
    public void cargaInicial() {
        listaUsuario.addAll(usuarioFacadeLocal.listarTodosUsuarios());
        listaPais.addAll(paisempleoFacadeLocal.listarTodosPaises());
        listaTipoId.addAll(tipoIdentificacionFacadeLocal.listarTodosTiposId());
        listaEstado.addAll(estadoFacadeLocal.listarTodosEstados());
        listaArea.addAll(areaFacadeLocal.listarTodasAreas());

    }

    public boolean validarCampos() {
        String error = "'";
        String campo = "";
        int contador = 0;
        boolean flag = true;
        primerApellido = lt.caracteresEspeciales(primerApellido.replace("\\s+ ", " "));
        segundoApellido = lt.caracteresEspeciales(segundoApellido.replace(" ", ""));
        primerNombre = lt.caracteresEspeciales(primerNombre.replace(" ", ""));
        otrosNombres = lt.caracteresEspeciales(otrosNombres.replace("\\s+ ", " "));
        numeroIdentificacion = lt.caracteresEspeciales(numeroIdentificacion.replace(" ", ""));

        if (primerApellido.equals("")) {
            campo = "Primer apellido";
            contador++;
        }
        if (segundoApellido.equals("")) {
            campo += " Segundo Apellido";
            contador++;
        }
        if (primerNombre.equals("")) {
            campo += " Primer Nombre";
            contador++;
        }
        if (numeroIdentificacion.equals("")) {
            campo += " Numero Identificación";
            contador++;
        }
        if (contador > 1) {
            error = "'Debe ingresar los campos de " + campo + "',";
            mensajes = "Swal.fire('Error!'," + error + " 'error')";
        } else if (contador == 1) {
            error = "'Debe ingresar el campo de " + campo + "',";
            mensajes = "Swal.fire('Error!'," + error + " 'error')";
        } else {
            if (!lt.letrasEspacio(primerApellido) || primerApellido.length() > 20) {
                flag = false;
                error = "Información erronea --- Primer Apellido --- Solo debe ingresar máximo 20 letras (A-Z)";
            }
            if (flag) {
                if (!lt.soloLetras(segundoApellido) || segundoApellido.length() > 20) {
                    flag = false;
                    error = "Información erronea --- Segundo Apellido --- Solo debe ingresar máximo 20 letras (A-Z)";
                }
            }
            if (flag) {
                if (!lt.soloLetras(primerNombre) || primerNombre.length() > 20) {
                    flag = false;
                    error = "Información erronea --- Primer Nombre solo debe ingresar máximo 20 letras (A-Z)";
                }
            }
            if (flag) {
                if (!lt.letrasEspacio(otrosNombres) || otrosNombres.length() > 50) {
                    flag = false;
                    error = "Información erronea --- Otros Nombres --- Solo debe ingresar máximo 50 letras (A-Z)";
                }
            }
            if (flag) {
                if (!lt.letrasIdentificacion(numeroIdentificacion) || numeroIdentificacion.length() > 20) {
                    flag = false;
                    error = "Información erronea --- Número Identificacón --- Caracteres permitidos: (a-z / A-Z / 0-9/ -)";
                }
            }
            if (flag) {
                mensajes = "Swal.fire('Bien hecho!','Campos Correctos','success')";
            } else {
                mensajes = "Swal.fire('Error!','" + error + "','error')";
            }
        }

        PrimeFaces.current().executeScript(mensajes);
        PrimeFaces.current().executeScript("$('#reset').click()");
        return flag;
    }

    public boolean validarCampos(String primerApellido, String segundoApellido, String primerNombre, String otrosNombres, String numeroIdentificacion) {
        String error = "'";
        String campo = "";
        int contador = 0;
        boolean flag = true;
        primerApellido = lt.caracteresEspeciales(primerApellido.replace("\\s+ ", " "));
        segundoApellido = lt.caracteresEspeciales(segundoApellido.replace(" ", ""));
        primerNombre = lt.caracteresEspeciales(primerNombre.replace(" ", ""));
        otrosNombres = lt.caracteresEspeciales(otrosNombres.replace("\\s+ ", " "));
        numeroIdentificacion = lt.caracteresEspeciales(numeroIdentificacion.replace(" ", ""));

        if (primerApellido.equals("")) {
            campo = "Primer apellido";
            contador++;
        }
        if (segundoApellido.equals("")) {
            campo += " Segundo Apellido";
            contador++;
        }
        if (primerNombre.equals("")) {
            campo += " Primer Nombre";
            contador++;
        }
        if (numeroIdentificacion.equals("")) {
            campo += " Numero Identificación";
            contador++;
        }
        if (contador > 1) {
            error = "'Debe ingresar los campos de " + campo + "',";
            mensajes = "Swal.fire('Error!'," + error + " 'error')";
        } else if (contador == 1) {
            error = "'Debe ingresar el campo de " + campo + "',";
            mensajes = "Swal.fire('Error!'," + error + " 'error')";
        } else {
            if (!lt.letrasEspacio(primerApellido) || primerApellido.length() > 20) {
                flag = false;
                error = "Información erronea --- Primer Apellido --- Solo debe ingresar máximo 20 letras (A-Z)";
            }
            if (flag) {
                if (!lt.soloLetras(segundoApellido) || segundoApellido.length() > 20) {
                    flag = false;
                    error = "Información erronea --- Segundo Apellido --- Solo debe ingresar máximo 20 letras (A-Z)";
                }
            }
            if (flag) {
                if (!lt.soloLetras(primerNombre) || primerNombre.length() > 20) {
                    flag = false;
                    error = "Información erronea --- Primer Nombre solo debe ingresar máximo 20 letras (A-Z)";
                }
            }
            if (flag) {
                if (!lt.letrasEspacio(otrosNombres) || otrosNombres.length() > 50) {
                    flag = false;
                    error = "Información erronea --- Otros Nombres --- Solo debe ingresar máximo 50 letras (A-Z)";
                }
            }
            if (flag) {
                if (!lt.letrasIdentificacion(numeroIdentificacion) || numeroIdentificacion.length() > 20) {
                    flag = false;
                    error = "Información erronea --- Número Identificacón --- Caracteres permitidos: (a-z / A-Z / 0-9/ -)";
                }
            }
            if (flag) {
                mensajes = "Swal.fire('Bien hecho!','Campos Correctos','success')";
            } else {
                mensajes = "Swal.fire('Error!','" + error + "','error')";
            }
        }

        PrimeFaces.current().executeScript(mensajes);
        PrimeFaces.current().executeScript("$('#reset').click()");
        return flag;
    }

    public boolean validarIdentidad() {
        boolean flag = true;
        for (Usuario usuario : listaUsuario) {
            if (usuario.getNumeroIdentificacion().equals(numeroIdentificacion) && usuario.getTipoIdentificacionIdtipoId().getIdtipoId() == tipoIdentificacion) {
                flag = false;
                break;
            } else {
                flag = true;
            }
        }
        return flag;
    }

    public void registrarUsuario() {
        try {
            if (validarIdentidad()) {
                if (validarCampos()) {
                    if (fh.fechaCorrecta(fechaIngreso).equals("OK")) {
                        listaUsuario.clear();
                        listaUsuario.addAll(usuarioFacadeLocal.listarTodosUsuarios());
                        correo = crearCorreo(primerNombre, primerApellido, paisEmpleo);

                        boolean respuesta = usuarioFacadeLocal.registrarUsuario(primerApellido.toUpperCase(), segundoApellido.toUpperCase(),
                                primerNombre.toUpperCase(), otrosNombres.toUpperCase(), paisEmpleo, tipoIdentificacion,
                                numeroIdentificacion, correo, fh.ordenarFecha(fechaIngreso), area, ESTADO, fh.fecha() + " " + fh.hora());
                        if (respuesta) {
                            mensajes = "Swal.fire('Bien hecho!','Usuario registrado correctamente','success')";

                        }
                        mensajes = "Swal.fire('Bien hecho!','Usuario registrado correctamente','success')";
                        listaUsuario.clear();
                        listaUsuario.addAll(usuarioFacadeLocal.listarTodosUsuarios());
                    } else if (fh.fechaCorrecta(fechaIngreso).equals("MENOR")) {
                        mensajes = "Swal.fire('Error!','La fecha no puede ser menor a un mes','error')";
                    } else if (fh.fechaCorrecta(fechaIngreso).equals("MAYOR")) {
                        mensajes = "Swal.fire('Error!','La fecha no puede ser mayor a la actual','error')";
                    }

                }
            } else {
                mensajes = "Swal.fire('Error!','Tipo y número de identificación ya registrado','error')";
            }

        } catch (Exception e) {
            mensajes = "Swal.fire('Error!','No se ha podido registrar el usuario','error')";
            System.out.println("com.cidenet.controller.ControllerApplication.registrarUsuario()" + e.getMessage());
        }
        PrimeFaces.current().executeScript(mensajes);
        PrimeFaces.current().executeScript("$('#reset').click()");
    }

    public String crearCorreo(String nombre, String apellido, int pais) {

        try {
            apellido = apellido.replaceAll(" ", "");

            int temp = 0;
            String complemento = "";
            String dominio = "";
            if (pais == 1) {
                dominio = "@cidenet.com.co";
                correo = nombre + "." + apellido + dominio;
            } else if (pais == 2) {
                dominio = "@cidenet.com.us";
                correo = nombre + "." + apellido + dominio;
            }

            for (Usuario list : listaUsuario) {
                listaCorreos.add(list.getCorreoElectronico());
            }
            while (listaCorreos.contains(correo)) {
                temp++;
                complemento = String.valueOf(temp);
                correo = nombre + "." + apellido + complemento + dominio;
            }
        } catch (Exception e) {
            System.out.println("com.cidenet.controller.ControllerApplication.crearCorreo()" + e.getMessage());
        }
        return correo.toLowerCase();
    }

    public void eliminarUsuario(Usuario user) {
        try {
            usuarioFacadeLocal.remove(user);
            listaUsuario.clear();
            listaUsuario.addAll(usuarioFacadeLocal.listarTodosUsuarios());
            mensajes = "Swal.fire('Bien hecho!','Usuario eliminado correctamente','success')";
        } catch (Exception e) {
            System.out.println("com.cidenet.controller.ControllerApplication.eliminarUsuario()" + e.getMessage());
            mensajes = "Swal.fire('Error!','No se ha podido eliminar el usuario','error')";
        }
        PrimeFaces.current().executeScript(mensajes);
        PrimeFaces.current().executeScript("$('#reset').click()");
    }

    public void seleccionarUsuario(int idUsuario) {
        usuSel = usuarioFacadeLocal.seleccionarUsuario(idUsuario);
        apellidoSel = usuSel.getPrimerApellido();
        nombreSel = usuSel.getPrimerNombre();
        numeroIdentificacion = usuSel.getNumeroIdentificacion();
        redir.redireccionar("/editar_usuario.xhtml");
    }

    public void perfilUsuario(int idUsuario) {
        usuSel = usuarioFacadeLocal.seleccionarUsuario(idUsuario);
        apellidoSel = usuSel.getPrimerApellido();
        nombreSel = usuSel.getPrimerNombre();
        numeroIdentificacion = usuSel.getNumeroIdentificacion();
        redir.redireccionar("/perfil_usuario.xhtml");
    }

    public void redirEditarUsuario() {
        redir.redireccionar("/editar_usuario.xhtml");
    }

    public void editarUsuario() {
        try {
            mensajes = "";
            numeroIdentificacion = usuSel.getNumeroIdentificacion();
            if (validarIdentidad()) {
                if (validarCampos(usuSel.getPrimerApellido(), usuSel.getSegundoApellido(), usuSel.getPrimerNombre(), usuSel.getOtrosNombres(), usuSel.getNumeroIdentificacion())) {
                    if (!apellidoSel.equals(usuSel.getPrimerApellido()) || !nombreSel.equals(usuSel.getPrimerNombre())) {
                        correo = crearCorreo(usuSel.getPrimerNombre(), usuSel.getPrimerApellido(), usuSel.getPaisEmpleoidpais().getIdpais());
                        usuSel.setCorreoElectronico(correo);
                    }else{
                        correo = usuSel.getCorreoElectronico();
                    }
                    usuarioFacadeLocal.editarUsuario(usuSel.getPrimerApellido().toUpperCase(),
                            usuSel.getSegundoApellido().toUpperCase(), usuSel.getPrimerNombre().toUpperCase(),
                            usuSel.getOtrosNombres().toUpperCase(), usuSel.getPaisEmpleoidpais().getIdpais(),
                            usuSel.getTipoIdentificacionIdtipoId().getIdtipoId(),
                            usuSel.getNumeroIdentificacion(), correo, usuSel.getAreaIdarea().getIdarea(),
                            fh.fecha() + " " + fh.hora(), usuSel.getIdusuario());
                    listaUsuario.clear();
                    listaUsuario.addAll(usuarioFacadeLocal.listarTodosUsuarios());
                    mensajes = "Swal.fire('Bien hecho!','Usuario editado correctamente','success')";
                }
            }

        } catch (Exception e) {
            mensajes = "Swal.fire('Error!','No se ha podido editar el usuario','error')";
            System.out.println("com.cidenet.controller.ControllerApplication.editarUsuario()" + e.getMessage());

        }
        PrimeFaces.current().executeScript(mensajes);
        PrimeFaces.current().executeScript("$('#reset').click()");

    }

    public void prueba() {
        System.out.println("Sirve");
    }
//    GETTER
//            &
//    SETTER

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<Paisempleo> getListaPais() {
        return listaPais;
    }

    public void setListaPais(List<Paisempleo> listaPais) {
        this.listaPais = listaPais;
    }

    public List<TipoIdentificacion> getListaTipoId() {
        return listaTipoId;
    }

    public void setListaTipoId(List<TipoIdentificacion> listaTipoId) {
        this.listaTipoId = listaTipoId;
    }

    public List<Estado> getListaEstado() {
        return listaEstado;
    }

    public void setListaEstado(List<Estado> listaEstado) {
        this.listaEstado = listaEstado;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getOtrosNombres() {
        return otrosNombres;
    }

    public void setOtrosNombres(String otrosNombres) {
        this.otrosNombres = otrosNombres;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Integer getPaisEmpleo() {
        return paisEmpleo;
    }

    public void setPaisEmpleo(Integer paisEmpleo) {
        this.paisEmpleo = paisEmpleo;
    }

    public Integer getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Integer TipoIdentificacion) {
        this.tipoIdentificacion = TipoIdentificacion;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Area> getListaArea() {
        return listaArea;
    }

    public void setListaArea(List<Area> listaArea) {
        this.listaArea = listaArea;
    }

    public Usuario getUsuSel() {
        return usuSel;
    }

    public void setUsuSel(Usuario usuSel) {
        this.usuSel = usuSel;
    }
}
