package data;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;

import data.properties.DataProperties;
import data.properties.NumericData;
import data.properties.SelectData;
import data.properties.SystemProperties;

public class Data implements Serializable {

	private static final long serialVersionUID = 6632461413087395187L;


	private ArrayList<Joueur> joueurs;
	private transient ArrayList<Joueur> joueursInGame;

	public Data() {
		joueurs = new ArrayList<Joueur>();
		joueursInGame = new ArrayList<Joueur>();
	}

	public void supprimerJoueur(Joueur j) {
		joueurs.remove(j);
	}
	
	public Joueur nouveauJoueur() {
		Joueur joueur = new Joueur(DataProperties.NOM_DEFAUT);
		joueurs.add(joueur);
		return joueur;
	}

	public void loadJoueursFromGame() {
		try  {
			RandomAccessFile raf = new RandomAccessFile(SystemProperties.PATH, "rw");
			
			joueursInGame.clear();
			
			Joueur joueur;
			for(int i=1;i<=20;i++) {
				joueur = new Joueur(getNomFromGame(raf, i));
				joueur.setPosition(getIntFromGame(raf, i, DataProperties.POSITION,0));
				joueur.setTypeCorps(getIntFromGame(raf, i, DataProperties.TYPECORPS,0));
				joueur.setTaille(getIntFromGame(raf, i, DataProperties.TAILLE,0));
				joueur.setTailleTete(getIntFromGame(raf, i, DataProperties.TAILLETETE,0));
				joueur.setCouleurPeau(getIntFromGame(raf, i, DataProperties.COULEURPEAU,0));
				joueur.setStyleManche(getIntFromGame(raf, i, DataProperties.STYLEMANCHE,0));
				joueur.setVisage(getIntFromGame(raf, i, DataProperties.VISAGE,0));
				joueur.setTailleBouche(getIntFromGame(raf, i, DataProperties.TAILLEBOUCHE,0));
				joueur.setCommissures(getIntFromGame(raf, i, DataProperties.COMMISSURES,0));
				joueur.setPositionBouche(getIntFromGame(raf, i, DataProperties.POSITIONBOUCHE,0));
				joueur.setCheveux(getIntFromGame(raf, i, DataProperties.CHEVEUX,0));
				joueur.setCouleurCheveux(getIntFromGame(raf, i, DataProperties.COULEURCHEVEUX,0));
				joueur.setYeux(getIntFromGame(raf, i, DataProperties.YEUX,0));
				joueur.setTailleYeux(getIntFromGame(raf, i, DataProperties.TAILLEYEUX,0));
				joueur.setPositionYeux(getIntFromGame(raf, i, DataProperties.POSITIONYEUX,0));
				joueur.setEspacementYeux(getIntFromGame(raf, i, DataProperties.ESPACEMENTYEUX,0));
				joueur.setTaillePupilles(getIntFromGame(raf, i, DataProperties.TAILLEPUPILLES,0));
				joueur.setCouleurYeux(getIntFromGame(raf, i, DataProperties.COULEURYEUX,0));
				joueur.setSourcils(getIntFromGame(raf, i, DataProperties.SOURCILS,0));
				joueur.setCouleurSourcils(getIntFromGame(raf, i, DataProperties.COULEURSOURCILS,0));
				joueur.setNez(getIntFromGame(raf, i, DataProperties.NEZ,0));
				joueur.setPositionNez(getIntFromGame(raf, i, DataProperties.POSITIONNEZ,0));
				joueur.setTailleNez(getIntFromGame(raf, i, DataProperties.TAILLENEZ,0));
				joueur.setCrampons(getIntFromGame(raf, i, DataProperties.CRAMPONS,0));
				joueur.setVoix(getIntFromGame(raf, i, DataProperties.VOIX,0));
				joueur.setLunettes(getIntFromGame(raf, i, DataProperties.LUNETTES,0));
				joueur.setCouleurLunettes(getIntFromGame(raf, i, DataProperties.COULEURLUNETTES,0));
				joueur.setCelebration1(getIntFromGame(raf, i, DataProperties.CELEBRATION,0));
				joueur.setCelebration2(getIntFromGame(raf, i, DataProperties.CELEBRATION,1));
				joueur.setCelebration3(getIntFromGame(raf, i, DataProperties.CELEBRATION,2));
				joueur.setCelebration4(getIntFromGame(raf, i, DataProperties.CELEBRATION,3));
				joueur.setAttaque(getIntFromGame(raf, i, DataProperties.STAT,0));
				joueur.setDefense(getIntFromGame(raf, i, DataProperties.STAT,1));
				joueur.setPuissance(getIntFromGame(raf, i, DataProperties.STAT,2));
				joueur.setVitesse(getIntFromGame(raf, i, DataProperties.STAT,3));
				joueur.setTechnique(getIntFromGame(raf, i, DataProperties.STAT,4));
				joueur.setTir(getIntFromGame(raf, i, DataProperties.TIRS,0));
				joueur.setTirAlt(getIntFromGame(raf, i, DataProperties.TIRS,1));
				joueur.setTirAerien(getIntFromGame(raf, i, DataProperties.TIRSAERIENS,0));
				joueur.setSuperTir(getIntFromGame(raf, i, DataProperties.SUPERTIRS,0));
				joueur.setSuperTirAlt(getIntFromGame(raf, i, DataProperties.SUPERTIRS,1));
				joueur.setDribble1(getIntFromGame(raf, i, DataProperties.DRIBBLES,0));
				joueur.setDribble2(getIntFromGame(raf, i, DataProperties.DRIBBLES,1));
				joueur.setPasse(getIntFromGame(raf, i, DataProperties.PASSES,0));
				joueur.setTirCombo1(getIntFromGame(raf, i, DataProperties.TIRSCOMBO1,0));
				joueur.setTirCombo2(getIntFromGame(raf, i, DataProperties.TIRSCOMBO2,0));
				joueur.setPassesCombo(getIntFromGame(raf, i, DataProperties.PASSESCOMBO,0));
				joueur.setTacle1(getIntFromGame(raf, i, DataProperties.TACLES,0));
				joueur.setTacle2(getIntFromGame(raf, i, DataProperties.TACLES,1));
				joueur.setBlocage(getIntFromGame(raf, i, DataProperties.BLOCAGES,0));
				joueur.setCompetenceCapitaine(getIntFromGame(raf, i, DataProperties.COMPETECESCAPITAINE,0));
				joueur.setCompetence1(getIntFromGame(raf, i, DataProperties.COMPETENCES,0));
				joueur.setCompetence2(getIntFromGame(raf, i, DataProperties.COMPETENCES,1));
				joueur.setCompetence3(getIntFromGame(raf, i, DataProperties.COMPETENCES,2));
				joueur.setCompetence4(getIntFromGame(raf, i, DataProperties.COMPETENCES,3));
				joueur.setCompetence5(getIntFromGame(raf, i, DataProperties.COMPETENCES,4));
				joueur.setCompetence6(getIntFromGame(raf, i, DataProperties.COMPETENCES,5));
				joueursInGame.add(joueur);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveIntoGame(Joueur joueur, int inGameIndex) {
		archiveSavedata();
		try {
			RandomAccessFile raf = new RandomAccessFile(SystemProperties.PATH, "rw");
			writeNomInGame(raf, inGameIndex, joueur.getNom());
			writeIntInGame(raf, inGameIndex, DataProperties.POSITION,0,joueur.getPosition());
			writeIntInGame(raf, inGameIndex, DataProperties.TYPECORPS,0,joueur.getTypeCorps());
			writeIntInGame(raf, inGameIndex, DataProperties.TAILLE,0,joueur.getTaille());
			writeIntInGame(raf, inGameIndex, DataProperties.TAILLETETE,0,joueur.getTailleTete());
			writeIntInGame(raf, inGameIndex, DataProperties.COULEURPEAU,0,joueur.getCouleurPeau());
			writeIntInGame(raf, inGameIndex, DataProperties.STYLEMANCHE,0,joueur.getStyleManche());
			writeIntInGame(raf, inGameIndex, DataProperties.VISAGE,0,joueur.getVisage());
			writeIntInGame(raf, inGameIndex, DataProperties.TAILLEBOUCHE,0,joueur.getTailleBouche());
			writeIntInGame(raf, inGameIndex, DataProperties.COMMISSURES,0,joueur.getCommissures());
			writeIntInGame(raf, inGameIndex, DataProperties.POSITIONBOUCHE,0,joueur.getPositionBouche());
			writeIntInGame(raf, inGameIndex, DataProperties.CHEVEUX,0,joueur.getCheveux());
			writeIntInGame(raf, inGameIndex, DataProperties.COULEURCHEVEUX,0,joueur.getCouleurCheveux());
			writeIntInGame(raf, inGameIndex, DataProperties.YEUX,0,joueur.getYeux());
			writeIntInGame(raf, inGameIndex, DataProperties.TAILLEYEUX,0,joueur.getTailleYeux());
			writeIntInGame(raf, inGameIndex, DataProperties.POSITIONYEUX,0,joueur.getPositionYeux());
			writeIntInGame(raf, inGameIndex, DataProperties.ESPACEMENTYEUX,0,joueur.getEspacementYeux());
			writeIntInGame(raf, inGameIndex, DataProperties.TAILLEPUPILLES,0,joueur.getTaillePupilles());
			writeIntInGame(raf, inGameIndex, DataProperties.COULEURYEUX,0,joueur.getCouleurYeux());
			writeIntInGame(raf, inGameIndex, DataProperties.SOURCILS,0,joueur.getSourcils());
			writeIntInGame(raf, inGameIndex, DataProperties.COULEURSOURCILS,0,joueur.getCouleurSourcils());
			writeIntInGame(raf, inGameIndex, DataProperties.NEZ,0,joueur.getNez());
			writeIntInGame(raf, inGameIndex, DataProperties.POSITIONNEZ,0,joueur.getPositionNez());
			writeIntInGame(raf, inGameIndex, DataProperties.TAILLENEZ,0,joueur.getTailleNez());
			writeIntInGame(raf, inGameIndex, DataProperties.CRAMPONS,0,joueur.getCrampons());
			writeIntInGame(raf, inGameIndex, DataProperties.VOIX,0,joueur.getVoix());
			writeIntInGame(raf, inGameIndex, DataProperties.LUNETTES,0,joueur.getLunettes());
			writeIntInGame(raf, inGameIndex, DataProperties.COULEURLUNETTES,0,joueur.getCouleurLunettes());
			writeIntInGame(raf, inGameIndex, DataProperties.CELEBRATION,0,joueur.getCelebration1());
			writeIntInGame(raf, inGameIndex, DataProperties.CELEBRATION,1,joueur.getCelebration2());
			writeIntInGame(raf, inGameIndex, DataProperties.CELEBRATION,2,joueur.getCelebration3());
			writeIntInGame(raf, inGameIndex, DataProperties.CELEBRATION,3,joueur.getCelebration4());
			writeIntInGame(raf, inGameIndex, DataProperties.STAT,0,joueur.getAttaque());
			writeIntInGame(raf, inGameIndex, DataProperties.STAT,1,joueur.getDefense());
			writeIntInGame(raf, inGameIndex, DataProperties.STAT,2,joueur.getPuissance());
			writeIntInGame(raf, inGameIndex, DataProperties.STAT,3,joueur.getVitesse());
			writeIntInGame(raf, inGameIndex, DataProperties.STAT,4,joueur.getTechnique());
			writeIntInGame(raf, inGameIndex, DataProperties.TIRS,0,joueur.getTir());
			writeIntInGame(raf, inGameIndex, DataProperties.TIRS,1,joueur.getTirAlt());
			writeIntInGame(raf, inGameIndex, DataProperties.TIRSAERIENS,0,joueur.getTirAerien());
			writeIntInGame(raf, inGameIndex, DataProperties.SUPERTIRS,0,joueur.getSuperTir());
			writeIntInGame(raf, inGameIndex, DataProperties.SUPERTIRS,1,joueur.getSuperTirAlt());
			writeIntInGame(raf, inGameIndex, DataProperties.DRIBBLES,0,joueur.getDribble1());
			writeIntInGame(raf, inGameIndex, DataProperties.DRIBBLES,1,joueur.getDribble2());
			writeIntInGame(raf, inGameIndex, DataProperties.PASSES,0,joueur.getPasse());
			writeIntInGame(raf, inGameIndex, DataProperties.TIRSCOMBO1,0,joueur.getTirCombo1());
			writeIntInGame(raf, inGameIndex, DataProperties.TIRSCOMBO2,0,joueur.getTirCombo2());
			writeIntInGame(raf, inGameIndex, DataProperties.PASSESCOMBO,0,joueur.getPassesCombo());
			writeIntInGame(raf, inGameIndex, DataProperties.TACLES,0,joueur.getTacle1());
			writeIntInGame(raf, inGameIndex, DataProperties.TACLES,1,joueur.getTacle2());
			writeIntInGame(raf, inGameIndex, DataProperties.BLOCAGES,0,joueur.getBlocage());
			writeIntInGame(raf, inGameIndex, DataProperties.COMPETECESCAPITAINE,0,joueur.getCompetenceCapitaine());
			writeIntInGame(raf, inGameIndex, DataProperties.COMPETENCES,0,joueur.getCompetence1());
			writeIntInGame(raf, inGameIndex, DataProperties.COMPETENCES,1,joueur.getCompetence2());
			writeIntInGame(raf, inGameIndex, DataProperties.COMPETENCES,2,joueur.getCompetence3());
			writeIntInGame(raf, inGameIndex, DataProperties.COMPETENCES,3,joueur.getCompetence4());
			writeIntInGame(raf, inGameIndex, DataProperties.COMPETENCES,4,joueur.getCompetence5());
			writeIntInGame(raf, inGameIndex, DataProperties.COMPETENCES,5,joueur.getCompetence6());
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getNomFromGame(RandomAccessFile raf, int j) throws Exception {
		String nom = "";
		boolean stop = false;
		int nextRead;
		raf.seek(DataProperties.JOUEURS_ADDRESS.get(j) + DataProperties.NOM_OFFSET);
		for(int i=0;i<DataProperties.NOM_LONGUEUR && !stop ;i++) {
			nextRead = raf.read();
			stop = nextRead == 0;
			if(!stop) {
				nom += (char)nextRead;
			}
		}
		return nom;
	}
	
	private int getIntFromGame(RandomAccessFile raf,int j, SelectData props, int offsetIdex) throws Exception {
		int i = getIntFromGame(raf, DataProperties.JOUEURS_ADDRESS.get(j), props.getOffsets()[offsetIdex]);
		return props.getIndexFromInGameValue(i, props.getDefaut());
	}
	
	private int getIntFromGame(RandomAccessFile raf,int j, NumericData props, int offsetIdex) throws Exception {
		int i = getIntFromGame(raf, DataProperties.JOUEURS_ADDRESS.get(j), props.getOffsets()[offsetIdex]);
		return i;
	}
	
	private int getIntFromGame(RandomAccessFile raf, Long address, int offset) throws Exception {
		raf.seek(address + offset);
		byte[] bytesVal = new byte[2];
		bytesVal[1]=raf.readByte();
		bytesVal[0]=raf.readByte();
		ByteBuffer wrapped = ByteBuffer.wrap(bytesVal);
		return Short.toUnsignedInt(wrapped.getShort());
	}
	
	private void writeNomInGame(RandomAccessFile raf, int j, String nom) throws Exception {
		raf.seek(DataProperties.JOUEURS_ADDRESS.get(j) + DataProperties.NOM_OFFSET);
		for(int i=0;i<DataProperties.NOM_LONGUEUR;i++) {
			if(i<nom.length()) {
				raf.write(nom.charAt(i));
			} else {
				raf.write(0);
			}
		}
	}
	
	private void writeIntInGame(RandomAccessFile raf,int j, SelectData props, int offsetIdex, int value) throws Exception {
		writeIntInGame(raf, DataProperties.JOUEURS_ADDRESS.get(j), props.getOffsets()[offsetIdex], props.getVals().get(value).getInGameValue());
	}
	
	private void writeIntInGame(RandomAccessFile raf,int j, NumericData props, int offsetIdex, int value) throws Exception {
		writeIntInGame(raf, DataProperties.JOUEURS_ADDRESS.get(j), props.getOffsets()[offsetIdex], value);
	}
	
	private void writeIntInGame(RandomAccessFile raf, Long address, int offset, int value) throws Exception {
		raf.seek(address + offset);
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(value);
		byte[] bytesValue = {bb.array()[3], bb.array()[2]};
		raf.write(bytesValue);
	}
	
	private void archiveSavedata() {
	    try {
	    	Path copied = Paths.get("backup/savedata_" + new Date().toString().replace(":", "-"));
	    	Path originalPath = Paths.get(SystemProperties.PATH);
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public ArrayList<Joueur> getJoueursInGame() {
		return joueursInGame;
	}
}
