/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_andrescruz;

/**
 *
 * @author MBanegas
 */
public class Avion {
    String codigo,ingcarg,estado="Estacionado";
    int aniof,anioa,cap,motores;
    double peso,horas;
    public Avion(String codigo, int aniof, int anioa,int cap,double peso, double horas,int motores,String ingcarg ){
    this.codigo=codigo;
    this.aniof=aniof;
    this.anioa=anioa;
    this.cap=cap;
    this.peso=peso;
    this.horas=horas;
    this.motores=motores;
    this.ingcarg=ingcarg;
    }
    public void setCodigo(String codigo){
    this.codigo=codigo;
    }
    public String getCodigo(){
    return codigo;
    }
    public void setAniof(int aniof){
    this.aniof=aniof;
    }
    public int getAniof(){
    return aniof;
    }
    public void setAnioa(int anioa){
    this.anioa=anioa;
    }
    public int getAnioa(){
    return anioa;
    }
    public void setCap(int cap){
    this.cap=cap;
    }
    public int getCap(){
    return cap;
    }
    public void setPeso(double peso){
    this.peso=peso;
    }
    public double getPeso(){
    return peso;
    }
    public void setHoras(double horas){
    this.horas=horas;
    }
    public double getHoras(){
    return horas;
    }
    public void setMotores(int motores){
    this.motores=motores;
    }
    public int getMotores(){
    return motores;
    }
    public void setIngcarg(String Ingcarg){
    this.ingcarg=Ingcarg;
    }
    public String getIngcarg(){
    return ingcarg;
    }
    public void setEstado(String estado){
    this.estado=estado;
    }
    public String getEstado(){
    return estado;
    }
    
    @Override
    public String toString(){
    String avion="";
    avion+="Codigo: "+codigo+"\nAño de Fabricacion: "+aniof+"\nAño de ingreso al aeropuerto: "+anioa+"\nCapacidad de pasajeros: "+cap+"\nCapacidad de peso: "+peso+" Toneladas\nCantidad de Horas de Vuelo: "+horas+" horas \nCantidad de motores: "+motores+"\nEstado del avion: "+estado+"\nIngeniero a Cargo: "+ingcarg;
    return avion;
    }
}