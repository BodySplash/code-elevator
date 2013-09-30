package fr.bodysplash.codestory.domaine;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrdonanceurDemandes {

    private enum Direction {
        UP {
            @Override
            public Integer suivant(Integer étage) {
                return étage+1;
            }
        }, DOWN {
            @Override
            public Integer suivant(Integer étage) {
                return étage -1;
            }
        };

        public abstract Integer suivant(Integer étage);
    }

    public OrdonanceurDemandes() {
    }

    public void stock(int demande) {
        if(!demandes.contains(demande)) {
            demandes.add(demande);
        }
    }

    public void clear() {
        demandes.clear();
    }

    protected Optional<Integer> demandeSuivante(Integer étageCourant) {
        if(demandes.isEmpty()) {
            return Optional.empty();
        }
        Integer demandeSuivante = demandes.remove(0);
        List<Integer> chemin = cheminVers(étageCourant, demandeSuivante);
        if(chemin.get(0) != demandeSuivante) {
            Integer suivant = chemin.get(0);
            demandes.remove(suivant);
            return Optional.of(suivant);
        }
        return Optional.of(demandeSuivante);
    }

    private List<Integer> cheminVers(Integer étageCourant, Integer demandeSuivante) {
        if(étageCourant == demandeSuivante) {
            return Lists.newArrayList(étageCourant);
        }
        ArrayList<Integer> result = new ArrayList<>();
        Direction direction = directionEntre(étageCourant, demandeSuivante);
        for(int étage = direction.suivant(étageCourant);étage != demandeSuivante; étage = direction.suivant(étage) ) {
            if(demandes.contains(étage)) {
                result.add(étage);
            }
        }
        result.add(demandeSuivante);
        return result;
    }

    private Direction directionEntre(Integer étageCourant, Integer demandeSuivante) {
        if(étageCourant > demandeSuivante) {
            return Direction.DOWN;
        }
        return Direction.UP;
    }

    private List<Integer> demandes = new ArrayList<>();
}
