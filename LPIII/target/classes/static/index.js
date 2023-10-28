const URL_API = "http://localhost:8081/coffees";

function listarCafes() {
    fetch(URL_API)
        .then(response => response.json())
        .then(data => {
            const coffeeList = document.getElementById("coffee-list");
            coffeeList.innerHTML = "";
            data.forEach(coffee => {
                const listItem = document.createElement("li");
                listItem.textContent = coffee.name;
                const editButton = document.createElement('button');
                const deleteButton = document.createElement('button');
                editButton.innerHTML = "Editar";
                deleteButton.innerHTML = "Excluir";
                coffeeList.appendChild(listItem);
                coffeeList.appendChild(editButton);
                coffeeList.appendChild(deleteButton);

                editButton.addEventListener('click', () => editarCafe(coffee.id, listItem));
                deleteButton.addEventListener('click', () => deletarCafe(coffee.id, listItem, editButton, deleteButton));
            });
        });
}

function adicionarCafe() {
    const nome = document.getElementById("nome").value;
    const descricao = document.getElementById("descricao").value;
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

function editarCafe(id, listItem) {
    const newName = prompt("Digite o novo nome para o café:", listItem.textContent);
    if (newName !== null) {
        fetch(URL_API + "/" + id, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ name: newName }),
        })
            .then(response => response.json())
            .then(() => {
                listItem.textContent = newName;
            })
            .catch(error => console.log(error));
    }
}

function deletarCafe(id, listItem, editButton, deleteButton) {
    const confirmDelete = confirm("Tem certeza de que deseja excluir este café?");
    if (confirmDelete) {
        fetch(URL_API + "/" + id, {
            method: 'DELETE',
        })
            .then(() => {
                listItem.remove();
                editButton.remove();
                deleteButton.remove();
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
