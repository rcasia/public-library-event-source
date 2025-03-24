# public library event source

This is just playground.

# Some requests

## Get Books

```bash
curl --request GET \
  --url http://localhost:8080/books
```


## Register Books

```bash
curl --request POST \
  --url http://localhost:8080/books \
  --header 'content-type: application/json' \
  --data '{
  "id": "1",
  "title": "Bratz",
  "actor": "Bruno User"
}'
```


## Lend Books

```bash
curl --request POST \
  --url http://localhost:8080/books/1/lend \
  --header 'content-type: application/json' \
  --data '{
  "bookId": "1",
  "lender": "Bruno User"
}'

```


## Get Global Book Stats

```bash
curl --request GET \
  --url http://localhost:8080/books-stats \
  --header 'content-type: application/json'
```
