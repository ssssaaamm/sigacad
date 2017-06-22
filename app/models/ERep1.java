package models;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="reprobados")
public class ERep1 extends Model{
	@Id
	public Long id;
	public String carrera;
	public String materia;
	public Integer ano;
	public Integer ciclo; 
	public Integer reprobados;

}