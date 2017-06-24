package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import java.util.*;
import java.io.File;

import views.html.tactico.*;
import models.*;



/*para pdf*/
import it.innove.play.pdf.PdfGenerator;
import javax.inject.Inject;
/*para pdf*/



/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class TacticoController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */


     /*used for method factura()*/
    @Inject
    public PdfGenerator pdfGenerator;
    /*used for method factura()*/


    public Result home() {
        return ok(welcome.render());
    }
    public Result e_rep1(){
        return ok(e_rep1.render());
    }

    public Result procesar_rep1(){
        //parametros de formulario
        Map<String, String[]> values = request().body().asFormUrlEncoded();
        
        //obtenemos los parametros segun name de cada input
        String carrera = values.get("carrera")[0];        
        Integer anio = Integer.valueOf(values.get("anio")[0]);
       /* Integer maxi = Integer.valueOf(values.get("max")[0]);*/

        //hacemos la consulta
        List<TRep1> registros = TRep1.find.where().eq("carrera",carrera).eq("ano",anio).findList();
        
        //presentamos la salida
        return ok(s_rep1.render(registros,carrera,anio));
    }

    public Result pdf_rep1(){
         Map<String, String[]> values = request().body().asFormUrlEncoded();
        
        //obtenemos los parametros segun name de cada input
        String carrera = values.get("carrera")[0];        
        Integer anio = Integer.valueOf(values.get("anio")[0]);
       /* Integer ciclo = Integer.valueOf(values.get("ciclo")[0]);*/

        //hacemos la consulta
        List<TRep1> registros = TRep1.find.where().eq("carrera",carrera).eq("ano",anio).findList();
        
        //presentamos la salida
        return pdfGenerator.ok(pdf_rep1.render(registros,carrera,anio),Configuration.root().getString("application.host"));
    }

    public Result e_rep2(){
        return ok(e_rep2.render());
    }

    public Result procesar_rep2(){
        //parametros de formulario
        Map<String, String[]> values = request().body().asFormUrlEncoded();
        
        //obtenemos los parametros segun name de cada input
        String carrera = values.get("carrera")[0];        
        Integer anio = Integer.valueOf(values.get("anio")[0]);
        Integer ciclo = Integer.valueOf(values.get("ciclo")[0]);

        //hacemos la consulta
        List<TRep2> registros = TRep2.find.where().eq("carrera",carrera).eq("ano",anio).eq("ciclo",ciclo).findList();
        
        //presentamos la salida
        return ok(s_rep2.render(registros,carrera,anio,ciclo));
    }

    public Result pdf_rep2(){
        //parametros de formulario
        Map<String, String[]> values = request().body().asFormUrlEncoded();
        
        //obtenemos los parametros segun name de cada input
        String carrera = values.get("carrera")[0];        
        Integer anio = Integer.valueOf(values.get("anio")[0]);
        Integer ciclo = Integer.valueOf(values.get("ciclo")[0]);

        //hacemos la consulta
        List<TRep2> registros = TRep2.find.where().eq("carrera",carrera).eq("ano",anio).eq("ciclo",ciclo).findList();
        
        //presentamos la salida
        return pdfGenerator.ok(pdf_rep2.render(registros,carrera,anio,ciclo),Configuration.root().getString("application.host"));
    }

    public Result e_rep3(){
        return ok(e_rep3.render());
    }

    public Result procesar_rep3(){
        return ok("procesando reporte 3");
    }

    public Result pdf_rep3(){
        return ok("generando pdf");
    }

    public Result e_rep4(){
        return ok(e_rep4.render());
    }

    public Result procesar_rep4(){
         Map<String, String[]> values = request().body().asFormUrlEncoded();
        
        //obtenemos los parametros segun name de cada input
          
        Integer anio = Integer.valueOf(values.get("anio")[0]);

        //hacemos la consulta
        List<TRep4> registros = TRep4.find.where().eq("ano",anio).findList();
        
        //presentamos la salida
        return ok(s_rep4.render(registros,anio));
    }

    public Result pdf_rep4(){
        //parametros de formulario
        Map<String, String[]> values = request().body().asFormUrlEncoded();
        
        //obtenemos los parametros segun name de cada input
        Integer anio = Integer.valueOf(values.get("anio")[0]);

        //hacemos la consulta
        List<TRep4> registros = TRep4.find.where().eq("ano",anio).findList();
        
        //presentamos la salida
        return pdfGenerator.ok(pdf_rep4.render(registros,anio),Configuration.root().getString("application.host"));
    }

    public Result e_rep5(){
        return ok(e_rep5.render());
    }

    public Result procesar_rep5(){
        //parametros de formulario
        Map<String, String[]> values = request().body().asFormUrlEncoded();
        
        //obtenemos los parametros segun name de cada input
        String carrera = values.get("carrera")[0];        
        Integer anio = Integer.valueOf(values.get("anio")[0]);
        Integer ciclo = Integer.valueOf(values.get("ciclo")[0]);

        //hacemos la consulta
        List<TRep5> registros = TRep5.find.where().eq("carrera",carrera).eq("ano",anio).eq("ciclo",ciclo).findList();
        
        //presentamos la salida
        return ok(s_rep5.render(registros,carrera,anio,ciclo));
    }

    public Result pdf_rep5(){
        //parametros de formulario
        Map<String, String[]> values = request().body().asFormUrlEncoded();
        
        //obtenemos los parametros segun name de cada input
        String carrera = values.get("carrera")[0];        
        Integer anio = Integer.valueOf(values.get("anio")[0]);
        Integer ciclo = Integer.valueOf(values.get("ciclo")[0]);

        //hacemos la consulta
        List<TRep5> registros = TRep5.find.where().eq("carrera",carrera).eq("ano",anio).eq("ciclo",ciclo).findList();
        
        //presentamos la salida
        return pdfGenerator.ok(pdf_rep5.render(registros,carrera,anio,ciclo),Configuration.root().getString("application.host"));
    }

}
