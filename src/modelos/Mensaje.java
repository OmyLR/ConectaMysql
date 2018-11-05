package modelos;

public class Mensaje {
	private String mensaje;
	private TiposMensje tipo;
	private String cssStyle;
	
	public Mensaje() {}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public TiposMensje getTipo() {
		return tipo;
	}

	public void setTipo(TiposMensje tipo) {
		this.tipo = tipo;
		switch(tipo) {
			case WARNING:
				setCssStyle("alert-danger");
				break;
			case SUCCESS:
				setCssStyle("alert-success");
				break;
		}
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	
	
	
	
	
}
