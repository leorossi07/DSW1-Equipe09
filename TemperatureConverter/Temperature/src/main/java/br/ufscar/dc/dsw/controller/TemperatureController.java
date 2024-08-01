package br.ufscar.dc.dsw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufscar.dc.dsw.domain.Intervalo;

@Controller
public class TemperatureController {

    @GetMapping("/")
    public String index(Intervalo intervalo) {
        return "index";
    }

    @RequestMapping(path = "/lista", method = {RequestMethod.GET, RequestMethod.POST})
    public String conversao(Intervalo intervalo, Model model) {
        List<Temperatura> lista = listaTemperaturas(intervalo.getMinimo(), intervalo.getMaximo());
        model.addAttribute("lista", lista);
        return "lista";
    }

    private static List<Temperatura> listaTemperaturas(int minimo, int maximo) {
        List<Temperatura> lista = new ArrayList<>();
        for (int i = minimo; i <= maximo; i += 5) {
            int fahrenheit = (int) Math.round(i * 1.80 + 32);
            lista.add(new Temperatura(i, fahrenheit));
        }
        return lista;
    }

    public static class Temperatura {
        private int celsius;
        private int fahrenheit;

        public Temperatura(int celsius, int fahrenheit) {
            this.celsius = celsius;
            this.fahrenheit = fahrenheit;
        }

        public int getCelsius() {
            return celsius;
        }

        public int getFahrenheit() {
            return fahrenheit;
        }
    }
}
