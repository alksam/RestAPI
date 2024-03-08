### Metoder
Anmodningsmetoder:
- **pathParam()**: Bruges til at hente værdier fra sti-parametre i en URL.
- **header()**: Henter værdier fra HTTP-anmodningshoveder.
- **queryParam()**: Henter værdier fra URL-parametre (querystring).
- **req()**: Bruges til at hente anmodningsobjektet.
- **POST-eksempler**:
    - **bodyAsClass()**: Konverterer anmodningens krop til en klasse.
    - **bodyValidator()**: Validerer anmodningens krop.
- Svarmetoder:
    - **setContentType()**: Indstiller svarets indholdstype.
    - **setHeader()**: Indstiller HTTP-svarets hoveder.
    - **setStatus()**: Indstiller HTTP-statuskoden for svaret.
    - **json()**: Sender data som JSON.
    - **html()**: Sender HTML-indhold.
    - **render()**: Bruges til at rendere en skabelon.


### Handlers
Her er nogle relevante begreber inden for webapplikationer:

1. **Handlers (Håndterere)**:
    - Handlers er funktioner, der udføres, når der foretages en anmodning til et specifikt slutpunkt (endpoint).
    - De kan være lambda-udtryk, lokale funktioner, instansmetoder eller statiske metoder.
    - Handlers udføres, når ruten matcher anmodningen.

2. **Controllers (Styringsenheder)**:
    - Controllers er klasser, der kan levere flere handlers (normalt baseret på en bestemt ressource).
    - De aktiveres og afsluttes per anmodning.

3. **EndpointGroup (Slutpunktsgruppe)**:
    - En interface, der kan implementeres for at definere flere ruter (endpoints).
    - Bruges til at organisere og gruppere relaterede ruter.

4. **app.routes()**:
    - En metode, der bruges til at gruppere endpoints sammen.
    - Hjælper med at organisere og strukturere ruter i en webapplikation.

5. **app.path()**:
    - En metode, der bruges til at gruppere ruter sammen.
    - Giver mulighed for at organisere ruter baseret på fælles stier.
