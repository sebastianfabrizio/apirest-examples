package pe.edu.cibertec.appfundamentosrest.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundamentosService {

    public String validarNumeroPrimo(int numero) {
        if(numero<2){
            return "No es primo";
        }
        for(int i = 2; i <= Math.sqrt(numero); i++){
            if(numero%i == 0){
                return "No es primo";
            }
        }
        return "Es primo";
    }


    public String calcularFactorial(int numero) {
        if(numero<0){
            return "No se puede calcular factorial";
        }
        long factorial = 1;
        for(int i = 1; i <= numero; i++){
            factorial *= i;
        }
        return "El factorial es = "+ factorial;
    }

    public List<Integer> calcularFibonnaci(int numero) {
        List<Integer> fibonnaci = new ArrayList<Integer>();
        if(numero<=0){
            return fibonnaci;
        }
        int a = 0, b = 1;
        for(int i =0; i < numero; i++){
            fibonnaci.add(a);
            int siguienteValor = a + b;
            a = b;
            b=siguienteValor;
        }
        return fibonnaci;
    }


}
