package com.examenT2.LP2_T2_Lastra_Franklin.util;

public class Alert {
    
    // Método mágico que genera el script flotante animado para tu examen
    public static String sweetToast(String message, String type, int timer) {
        return String.format(
            "<script>" +
            "Swal.fire({" +
            "  toast: true," +
            "  position: 'top-end'," +
            "  icon: '%s'," +
            "  title: '%s'," +
            "  showConfirmButton: false," +
            "  timer: %d," +
            "  timerProgressBar: true" +
            "});" +
            "</script>", 
            type, message, timer
        );
    }
}