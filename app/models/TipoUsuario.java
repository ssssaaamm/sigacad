package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="tipo_usuario")
public class TipoUsuario extends Model{
	@Id
	public Long id;

	@Constraints.Required(message="Debe ingresar el codigo")
	public Integer codigo;

	@Constraints.Required(message="Debe ingresar el nombre")
	public String nombre;

	@Constraints.Required(message="Debe ingresar una breve descripcion")
	public String descripcion;

	@OneToMany(mappedBy="tipo")
	public List<Usuario> usuarios;

    public static Finder<Long, TipoUsuario> find = new Finder<Long,TipoUsuario>(TipoUsuario.class);


    public static Map<String,String> options(){
	  	LinkedHashMap<String,String> opciones = new LinkedHashMap<String,String>();
	  	//List<Categoria> categorias=Categoria.find.orderBy("nombre").findList();
	  	for(TipoUsuario c : TipoUsuario.find.orderBy("nombre").findList()){
	  		opciones.put(c.id.toString(), c.nombre);
	  	}
	  	return opciones;
  	}

}