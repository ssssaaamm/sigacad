package models;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="materiasRepetidas")
public class ERep5 extends Model{
	@Id
	public Long id;
	public String carrera;
	public Integer ano;
	public Integer ciclo;
	public String materia;
	public Integer reinscritos;
	
	public static Finder<Long, ERep5> find = new Finder<Long,ERep5>(ERep5.class);
} 