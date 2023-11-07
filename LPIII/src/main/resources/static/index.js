const URL_API = "http://localhost:8081/coffees/";

function listarCafes() {
    fetch(URL_API)
        .then(response => response.json())
        .then(data => {
            const coffeeList = document.getElementById("coffee-list");
            coffeeList.innerHTML = "";
            data.forEach(coffee => {
                const row = document.createElement("tr");
                
                const idCell = document.createElement("td");
                idCell.textContent = coffee.id;
                
                const nameCell = document.createElement("td");
                nameCell.textContent = coffee.name;

                const editButton = document.createElement('button');
                editButton.innerHTML = "Editar";
                const deleteButton = document.createElement('button');
                deleteButton.innerHTML = "Excluir";

                const actionCell = document.createElement("td");
                actionCell.appendChild(editButton);
                actionCell.appendChild(deleteButton);

                row.appendChild(idCell);
                row.appendChild(nameCell);
                row.appendChild(actionCell);

                coffeeList.appendChild(row);

                editButton.addEventListener('click', () => editarCafe(coffee.id, nameCell));
                deleteButton.addEventListener('click', () => deletarCafe(coffee.id, row));
            });
        });
}

function adicionarCafe() {
    const nome = document.getElementById("nome").value;
    const cafe = { name: nome };

    fetch(URL_API, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(cafe),
    })
        .then(response => response.json())
        .then(() => {
            listarCafes();
            fecharModal();
        })
        .catch(error => console.log(error));
}

function editarCafe(id, nameCell) {
    const newName = prompt("Digite o novo nome para o café:", nameCell.textContent);
    if (newName !== null) {
        fetch(URL_API + id, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ name: newName}),
        })
            .then(response => response.json())
            .then(() => {
                nameCell.textContent = newName;
            })
            .catch(error => console.log(error));
    }
}

function deletarCafe(id, row) {
    const confirmDelete = confirm("Tem certeza de que deseja excluir este café?");
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
    const modal = document.getElementById("modalAdicionarCafe");
    modal.style.display = "block";
}

function fecharModal() {
    const modal = document.getElementById("modalAdicionarCafe");
    modal.style.display = "none";
}

document.addEventListener("DOMContentLoaded", () => {
    listarCafes();
});
