package models;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="aprobadosReprobados")
public class TRep2 extends Model{
	@Id
	public Long id;
	public String carrera;
	public Integer ano;
	public Integer ciclo;
	public String docente;
	public String materia;
	public Integer aprobados;
    public Integer reprobados;
} 