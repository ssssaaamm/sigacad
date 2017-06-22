package models;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="retirados")
public class ERep3 extends Model{
	@Id
	public Long id;
	public String carrera;
	public Date fecha;
	public Integer retirados;



}