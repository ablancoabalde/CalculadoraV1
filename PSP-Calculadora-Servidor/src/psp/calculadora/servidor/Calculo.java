package psp.calculadora.servidor;

public class Calculo {

    String devResultado;

    /**
     * Funciónn que realiza los calculos de las operaciones recibidas y devuelve
     * un string con el resultado.
     *
     * La operación la recibe como un string en el que dentro se divide en
     * partes para realizar las operaciones.
     *
     * @param operacion
     * @return devResultado
     */
    public String calculo(String operacion) {

        String[] parts = operacion.split("n");
        float num1 = Float.parseFloat(parts[0]);

        float resultado = 0;

        // La parts[1] siempre será donde este el signo operador
        if (parts[1].equalsIgnoreCase("√")) {
            resultado = (float) Math.sqrt(num1);
        } else {

            float num2 = Float.parseFloat(parts[2]);

            System.out.println("operacion" + operacion);

            switch (parts[1]) {
                case ("+"):
                    resultado = num1 + num2;
                    break;
                case ("-"):
                    resultado = num1 - num2;
                    break;

                case ("/"):
                    if (num2 == 0) {
                        resultado = Float.POSITIVE_INFINITY;
                    } else {
                        resultado = num1 / num2;
                    }

                    break;

                case ("*"):
                    resultado = num1 * num2;
                    break;

                default:
                    System.out.println("hola");
                    break;
            }

        }
        return devResultado = String.valueOf(resultado);

    }
}
