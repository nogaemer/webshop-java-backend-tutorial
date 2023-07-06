<h4>
    - Pfad <br>
    - Query-Parameter <br>
    - Http Verb: GET, POST, PUT, DELETE, (HEAD, OPTIONS, PATCH, TRACE) <br>
    - Request Body <br>
<br>
REST: Ressourcen <br>
Produkte <br>
Kunden <br>
Bestellungen <br>
</h4>


Lade alle Produkte vom Server: <br>
GET /<strong>api</strong>/products

<strong>Lade alle Produkte</strong> <br>
GET /api/products <br>

<strong>Lade Produkte mit bestimmtem Tag</strong> <br>
GET /api/products?tag={tag}

<strong>Erzeuge neues Produkt</strong> <br>
POST /api/products <br>

<strong>Lösche Produkt</strong> <br>
DELETE /api/products/{id} <br>

<strong>Lade Produkte mit bestimmter ID</strong> <br>
GET /api/products/{id}

<strong>Ändere Preis eines Produktes</strong> <br>
PUT /api/products/{id}/price

<strong>Update Produktbeschreibung</strong> <br>
PUT /api/products/{id}/description

<strong>Update Produkt</strong> <br>
PUT /api/products/{id}

<strong>Füge Tag zu Produkt hinzu</strong> <br>
PUT /api/products/{id}/tags

<strong>Bestelle Produkt --> Erzeuge neue Bestellung </strong> <br>
POST /api/orders

<strong>Füge Produkt zu Bestellung hinzu</strong> <br>
POST /api/orders/{id}/products

<strong>Lade alle Bestellungen</strong> <br>
GET /api/orders




