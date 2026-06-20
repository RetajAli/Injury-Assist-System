public class Treatment {
    private String injuryType;
    private String treatmentSuggestion;

    public Treatment(String injuryType, String treatmentSuggestion) {
        this.injuryType = injuryType;
        this.treatmentSuggestion = treatmentSuggestion;
    }



    public String getTreatmentSuggestion() {
        return treatmentSuggestion;
    }

    public void displayTreatment() {
        System.out.println("Treatment for " + injuryType + ": " + treatmentSuggestion);
    }

    // Modify getTreatment to return a Treatment object, not just a string
    public static Treatment getTreatment(String injuryName) {
        String treatmentSuggestion = "";

        switch (injuryName) {
            case "Broken bones":
                treatmentSuggestion = "Immobilize the area with a splint or cast and seek medical attention immediately.";
                break;
            case "Burn":
                treatmentSuggestion = "Cool the burn with running water for 10-15 minutes, avoid popping blisters, and apply sterile dressings.";
                break;
            case "Ankle Sprain":
                treatmentSuggestion = "Use the RICE method: Rest, Ice, Compression, and Elevation to reduce swelling and pain.";
                break;
            case "Wrist sprain":
                treatmentSuggestion = "Rest the wrist, apply ice, use a wrist brace, and avoid heavy lifting until it heals.";
                break;
            case "Bruise":
                treatmentSuggestion = "Apply an ice pack to reduce swelling and rest the affected area.";
                break;
            case "Shoulder Dislocation":
                treatmentSuggestion = "Do not attempt to move the shoulder; immobilize it and seek emergency medical care.";
                break;
            case "Muscle Cramps":
                treatmentSuggestion = "Stretch and massage the affected muscle, stay hydrated, and apply heat to relax the muscle.";
                break;
            case "Finger Dislocation":
                treatmentSuggestion = "Do not try to reset the finger; immobilize it and seek professional medical help.";
                break;
            case "ACL":
                treatmentSuggestion = "Rest the knee, apply ice, use compression bandages, and consult an orthopedic specialist for possible surgery.";
                break;
            case "Torn Muscles":
                treatmentSuggestion = "Rest the muscle, use ice to reduce swelling, and follow a physical therapy plan for recovery.";
                break;
            case "Nose Fracture":
                treatmentSuggestion = "Keep the head elevated, apply a cold compress, and visit a doctor for proper alignment and care.";
                break;
            case "Achilles Tendon Tear":
                treatmentSuggestion = "Immobilize the foot, apply ice, and consult a specialist for possible surgical repair.";
                break;
            default:
                treatmentSuggestion = "No specific treatment found. Consult a healthcare provider for proper care.";
                break;
        }

        return new Treatment(injuryName, treatmentSuggestion); // Return the Treatment object
    }
}