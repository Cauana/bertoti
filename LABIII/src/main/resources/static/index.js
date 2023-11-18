const URL_API = "http://localhost:8081/books/";

function listarLivros() {
    fetch(URL_API)
        .then(response => response.json())
        .then(data => {
            const bookList = document.getElementById("book-list");
            bookList.innerHTML = "";
            data.forEach(book => {
                const row = document.createElement("tr");
                
                const idCell = document.createElement("td");
                idCell.textContent = book.id;
                
                const titleCell = document.createElement("td");
                titleCell.textContent = book.title;

                const editButton = document.createElement('button');
                editButton.innerHTML = "Editar";
                const deleteButton = document.createElement('button');
                deleteButton.innerHTML = "Excluir";

                const actionCell = document.createElement("td");
                actionCell.appendChild(editButton);
                actionCell.appendChild(deleteButton);

                row.appendChild(idCell);
                row.appendChild(titleCell);
                row.appendChild(actionCell);

                bookList.appendChild(row);

                editButton.addEventListener('click', () => editarLivro(book.id, titleCell));
                deleteButton.addEventListener('click', () => deletarLivro(book.id, row));
            });
        });
}

function adicionarLivro() {
    const titulo = document.getElementById("titulo").value;
    const livro = { title: titulo };

    fetch(URL_API, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(livro),
    })
        .then(response => response.json())
        .then(data => {
            listarLivros();
            fecharModal();
        })
        .catch(error => console.log(error));
}

function editarLivro(id, titleCell) {
    const newTitle = prompt("Digite o novo título para o livro:", titleCell.textContent);
    if (newTitle !== null) {
        fetch(URL_API + id, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ title: newTitle }),
        })
            .then(response => response.json())
            .then(() => {
                titleCell.textContent = newTitle;
            })
            .catch(error => console.log(error));
    }
}

function deletarLivro(id, row) {
    const confirmDelete = confirm("Tem certeza de que deseja excluir este livro?");
    if (confirmDelete) {
        fetch(URL_API + id, {
            method: 'DELETE',
        })
            .then(() => {
                row.remove();
            })
            .catch(error => console.log(error));
    }
}

function abrirModal() {
    const modal = document.getElementById("modalAdicionarLivro");
    modal.style.display = "block";
}

function fecharModal() {
    const modal = document.getElementById("modalAdicionarLivro");
    modal.style.display = "none";
}

document.addEventListener("DOMContentLoaded", () => {
    listarLivros();
});
