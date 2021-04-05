function converteImagem() {

	imagem = document.getElementById('imagem').value;

	imgElem.setAttribute('src', "data:image/jpg;base64," + imagem);
}