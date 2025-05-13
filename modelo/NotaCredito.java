/* package modelo;

import java.util.Date;
import java.util.List;

public class NotaCredito {
    private int id;
    private int ventaId;
    private Date fecha;
    private String cliente;
    private List<ItemVenta> itemsDevueltos;
    private double montoAcreditado;
    private String motivo;
    private boolean procesada;

    public NotaCredito(int id, int ventaId, Date fecha, String cliente, List<ItemVenta> itemsDevueltos, double montoAcreditado, String motivo) {
        this.id = id;
        this.ventaId = ventaId;
        this.fecha = fecha;
        this.cliente = cliente;
        this.itemsDevueltos = itemsDevueltos;
        this.montoAcreditado = montoAcreditado;
        this.motivo = motivo;
        this.procesada = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenta> getItemsDevueltos() {
        return itemsDevueltos;
    }

    public void setItemsDevueltos(List<ItemVenta> itemsDevueltos) {
        this.itemsDevueltos = itemsDevueltos;
    }

    public double getMontoAcreditado() {
        return montoAcreditado;
    }

    public void setMontoAcreditado(double montoAcreditado) {
        this.montoAcreditado = montoAcreditado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isProcesada() {
        return procesada;
    }

    public void setProcesada(boolean procesada) {
        this.procesada = procesada;
    }

    
}
 */