# tim-sykkel
En liten applikasjon som viser en liste over de ulike stasjonene, og hvor mange tilgjengelige låser og ledige sykler som er på dem i øyeblikket.

# Hvordan kjøre programmet

Registrer deg her: https://developer.oslobysykkel.no/

Få en clientsecret som registreres i `application.properties` i feltet `client.secret=<clientsecret>`
Registrer deg her `https://developers.google.com/maps/` for å få api nøkkel til google maps slik at du kan legge det inn som verdi
på variablen `google.api.key`

Først kjør `mvn clean install` && `mvn clean package` deretter `java -jar target/tim-sykkel-0.1.0.jar`

Start nettleser på `http://localhost:8080/`

