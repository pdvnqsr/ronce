package data.properties;

import java.util.ResourceBundle;

public class TextsProperties {

	public static String BUTTON_ADD;
	public static String BUTTON_CREATE;
	public static String BUTTON_DELETE;
	public static String BUTTON_SAVE;
	public static String BUTTON_TOGAME;
	public static String BUTTON_EXPORT;
	public static String BUTTON_IMPORT;
	
	public static String LABEL_JOUEURS;
	public static String LABEL_EQUIPES;
	public static String LABEL_LISTINGAME;
	public static String LABEL_LISTINSTOCK;
	public static String LABEL_NOM;
	public static String LABEL_POSTE;
	public static String LABEL_TYPECORPS;
	public static String LABEL_TAILLE;
	public static String LABEL_TAILLETETE;
	public static String LABEL_COULEURPEAU;
	public static String LABEL_STYLEMANCHES;	
	public static String LABEL_VISAGE;
	public static String LABEL_TAILLEBOUCHE;
	public static String LABEL_COMMISSURE;
	public static String LABEL_POSITIONBOUCHE;
	public static String LABEL_CHEVEUX;
	public static String LABEL_COULEURCHEVEUX;
	public static String LABEL_YEUX;
	public static String LABEL_TAILLEYEUX;
	public static String LABEL_POSITIONYEUX;
	public static String LABEL_ESPACEMENTYEUX;
	public static String LABEL_TAILLEPUPILLES;
	public static String LABEL_COULEURYEUX;
	public static String LABEL_SOURCILS;
	public static String LABEL_COULEURSOURCILS;
	public static String LABEL_NEZ;
	public static String LABEL_POSITIONNEZ;
	public static String LABEL_TAILLENEZ;
	public static String LABEL_CRAMPONS;
	public static String LABEL_VOIX;
	public static String LABEL_LUNETTES;
	public static String LABEL_COULEURLUNETTES;
	public static String LABEL_CELEBRATION;
	public static String LABEL_ATTAQUE;
	public static String LABEL_DEFENSE;
	public static String LABEL_PUISSANCE;
	public static String LABEL_VITESSE;
	public static String LABEL_TECHNIQUE;
	public static String LABEL_TIR;
	public static String LABEL_TIRAERIENS;
	public static String LABEL_SUPERTIR;
	public static String LABEL_DRIBBLE;
	public static String LABEL_PASSELONGUE;
	public static String LABEL_TIRSCOMBOS;
	public static String LABEL_PASSESCOMBO;
	public static String LABEL_TACLE;
	public static String LABEL_BLOCAGE;
	public static String LABEL_COMPETECECAPITAINE;
	public static String LABEL_COMPETENCE;
	public static String LABEL_ABREVIATION;
	public static String LABEL_EMBLEME;
	public static String LABEL_FOND;
	public static String LABEL_PIECE;
	public static String LABEL_MOTIF;
	public static String LABEL_COULEUR;
	public static String LABEL_MILIEU;
	public static String LABEL_COTE;
	public static String LABEL_HAUT;
	public static String LABEL_BAS;
	public static String LABEL_TRIPIECES;
	
	public static String MESSAGE_IRREVERSIBLE;
	public static String MESSAGE_SURE;
	public static String MESSAGE_EXPORT1;
	public static String MESSAGE_EXPORT2;
	public static String MESSAGE_IMPORTERROR;
	public static String MESSAGE_IMPORT;
	public static String MESSAGE_DELETE;
	public static String MESSAGE_ADDPLAYERS;
	public static String MESSAGE_TOGAME1;
	public static String MESSAGE_TOGAME2;
	
	
	static {
		ResourceBundle texts = ResourceBundle.getBundle("data.properties.texts.texts");
		BUTTON_ADD = texts.getString("button.add");
		BUTTON_CREATE = texts.getString("button.create");
		BUTTON_DELETE = texts.getString("button.delete");
		BUTTON_SAVE = texts.getString("button.save");
		BUTTON_TOGAME = texts.getString("button.toGame");
		BUTTON_EXPORT = texts.getString("button.export");
		BUTTON_IMPORT = texts.getString("button.import");
		
		LABEL_JOUEURS = texts.getString("label.joueurs");
		LABEL_EQUIPES = texts.getString("label.equipes");
		LABEL_LISTINGAME = texts.getString("label.listInGame");
		LABEL_LISTINSTOCK = texts.getString("label.listInStock");
		LABEL_NOM = texts.getString("label.nom");
		LABEL_POSTE = texts.getString("label.poste");
		LABEL_TYPECORPS = texts.getString("label.typeCorps");
		LABEL_TAILLE = texts.getString("label.taille");
		LABEL_TAILLETETE = texts.getString("label.tailleTete");
		LABEL_COULEURPEAU = texts.getString("label.couleurPeau");
		LABEL_STYLEMANCHES = texts.getString("label.styleManches");
		LABEL_VISAGE = texts.getString("label.visage");
		LABEL_TAILLEBOUCHE = texts.getString("label.tailleBouche");
		LABEL_COMMISSURE = texts.getString("label.commissure");
		LABEL_POSITIONBOUCHE = texts.getString("label.positionBouche");
		LABEL_CHEVEUX = texts.getString("label.cheveux");
		LABEL_COULEURCHEVEUX = texts.getString("label.couleurCheveux");
		LABEL_YEUX = texts.getString("label.yeux");
		LABEL_TAILLEYEUX = texts.getString("label.tailleYeux");
		LABEL_POSITIONYEUX = texts.getString("label.positionYeux");
		LABEL_ESPACEMENTYEUX = texts.getString("label.espacementYeux");
		LABEL_TAILLEPUPILLES = texts.getString("label.taillePupilles");
		LABEL_COULEURYEUX = texts.getString("label.couleurYeux");
		LABEL_SOURCILS = texts.getString("label.sourcils");
		LABEL_COULEURSOURCILS = texts.getString("label.couleurSourcils");
		LABEL_NEZ = texts.getString("label.nez");
		LABEL_POSITIONNEZ = texts.getString("label.positionNez");
		LABEL_TAILLENEZ = texts.getString("label.tailleNez");
		LABEL_CRAMPONS = texts.getString("label.crampons");
		LABEL_VOIX = texts.getString("label.voix");
		LABEL_LUNETTES = texts.getString("label.lunettes");
		LABEL_COULEURLUNETTES = texts.getString("label.couleurLunettes");
		LABEL_CELEBRATION = texts.getString("label.celebration");
		LABEL_ATTAQUE = texts.getString("label.attaque");
		LABEL_DEFENSE = texts.getString("label.defense");
		LABEL_PUISSANCE = texts.getString("label.puissance");
		LABEL_VITESSE = texts.getString("label.vitesse");
		LABEL_TECHNIQUE = texts.getString("label.technique");
		LABEL_TIR = texts.getString("label.tir");
		LABEL_TIRAERIENS = texts.getString("label.tirAerien");
		LABEL_SUPERTIR = texts.getString("label.superTir");
		LABEL_DRIBBLE = texts.getString("label.dribble");
		LABEL_PASSELONGUE = texts.getString("label.passeLongue");
		LABEL_TIRSCOMBOS = texts.getString("label.tirCombos");
		LABEL_PASSESCOMBO = texts.getString("label.passesCombo");
		LABEL_TACLE = texts.getString("label.table");
		LABEL_COMPETECECAPITAINE = texts.getString("label.competenceCapitaine");
		LABEL_COMPETENCE = texts.getString("label.competence");
		LABEL_ABREVIATION = texts.getString("label.abreviation");
		LABEL_EMBLEME = texts.getString("label.embleme");
		LABEL_FOND = texts.getString("label.fond");
		LABEL_PIECE = texts.getString("label.piece");
		LABEL_MOTIF = texts.getString("label.motif");
		LABEL_COULEUR = texts.getString("label.couleur");
		LABEL_MILIEU = texts.getString("label.milieu");
		LABEL_COTE = texts.getString("label.cote");
		LABEL_HAUT = texts.getString("label.haut");
		LABEL_BAS = texts.getString("label.bas");
		LABEL_TRIPIECES = texts.getString("label.triPieces");
		
		MESSAGE_IRREVERSIBLE = texts.getString("message.irreversible");
		MESSAGE_SURE = texts.getString("message.sure");
		MESSAGE_EXPORT1 = texts.getString("message.export1");
		MESSAGE_EXPORT2 = texts.getString("message.export2");
		MESSAGE_IMPORTERROR = texts.getString("message.importError");
		MESSAGE_IMPORT = texts.getString("message.import");
		MESSAGE_DELETE = texts.getString("message.delete");
		MESSAGE_ADDPLAYERS = texts.getString("message.addPlayers");
		MESSAGE_TOGAME1 = texts.getString("message.toGame1");
		MESSAGE_TOGAME2 = texts.getString("message.toGame2");
	}
}
