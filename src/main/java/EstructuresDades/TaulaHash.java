package EstructuresDades;

import java.util.ArrayList;
import java.util.List;

public class TaulaHash {
    public float [] indexarHash(List<String> strings, List<Float> interes, List <String> hashNoms) {
        int i;
        float [] hashMap = new float [strings.size()];
        cleanHashes(hashNoms);
        for (int j= 0; j < strings.size(); j++) {
            int valor = 0;
            i = 0;
            for (i = 2;i < strings.get(j).length();i = i+3) {
                valor = valor + (strings.get(j).charAt(i-2) + strings.get(j).charAt(i-1)) * strings.get(j).charAt(i);
            }
            i = i - 3;
            if (i != (strings.get(j).length() - 1)) {
                if (i == strings.get(j).length() - 2) {
                    valor = valor + strings.get(j).charAt(i+1);
                }
                else {
                    valor = valor + strings.get(j).charAt(i+1) + strings.get(j).charAt(i+2);
                }
            }
            valor = valor % strings.size();
            if (hashMap[valor] == 0) {
                hashMap[valor] = interes.get(j);
                hashNoms.add(strings.get(j));
            }
            else {
                int posicioLliure = j;
                while (hashMap[posicioLliure]!= 0){
                    posicioLliure++;
                    if (posicioLliure == strings.size()) {
                        posicioLliure = 0;
                    }
                }
                hashMap[valor] = interes.get(j);
                hashNoms.add(strings.get(j));
            }
        }
        return hashMap;
    }
    public int hash (String string, List <String> hashNoms) { //Mida del hashMap
        int valor = 0;
        int i;
        int valor_inicial;
        boolean volta_completa;
        for (i = 2;i < string.length();i = i+3) {
            valor = valor + (string.charAt(i-2) + string.charAt(i-1)) * string.charAt(i);
        }
        i = i - 3;
        if (i != (string.length() - 1)) {
            if (i == string.length() - 2) {
                valor = valor + string.charAt(i+1);
            }
            else {
                valor = valor + string.charAt(i+1) + string.charAt(i+2);
            }
        }
        valor = valor % hashNoms.size();
        valor_inicial = valor;
        volta_completa = false;
        if (!string.equals(hashNoms.get(valor))) {
            while (!volta_completa && !string.equals(hashNoms.get(valor))) {
                valor++;
                if (valor == hashNoms.size()) {
                    valor = 0;
                }
                if(valor_inicial == valor) {
                    volta_completa = true;
                    valor = - 1;
                }
            }
        }
        return valor;
    }
    public void cleanHashes (List <String> hashNoms) {
        if (hashNoms != null) {
            for (int j = 0; j < hashNoms.size(); j++) {
                hashNoms.set(j,"");
            }
        }
    }
}
