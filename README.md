# simple-notes-app-39317-39371

Notes backend (Spring Boot) provides REST API:

- Swagger UI: /swagger-ui.html (also link via /docs)
- OpenAPI JSON: /openapi.json
- Health: /health
- CRUD:
  - GET /api/notes
  - GET /api/notes/{id}
  - POST /api/notes
  - PUT /api/notes/{id}
  - DELETE /api/notes/{id}

Sample payload:
{
  "title": "My Note",
  "content": "This is the content"
}