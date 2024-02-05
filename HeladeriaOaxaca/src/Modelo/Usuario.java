package Modelo;

public class Usuario {

    private int id;
    private String nombreCompleto;
    private String usuario;
    private String password;
    private int estado; // 1=Activo 0=Inactivo
    private String privilegio; // Gerente - Admin - Cajero - Comprador

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public Usuario() {
    }

    public Usuario(int id, String nombreCompleto, String usuario, String password, int estado, String privilegio) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.privilegio = privilegio;
    }

    @Override
    public String toString() {
        return "Cajero{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", usuario=" + usuario + ", password=" + password + ", estado=" + estado + '}';
    }

}
