class Calendario {
  constructor(inputId, hiddenId) {
    this.inputId = inputId;
    this.hiddenId = hiddenId;
  }

  inicializar() {
    const input = document.getElementById(this.inputId);
    const hiddenInput = document.getElementById(this.hiddenId);

    if (!input || !hiddenInput) {
      console.error("No se encontraron los elementos necesarios.");
      return;
    }

    input.addEventListener("focus", () => {
      this.mostrarCalendario();
    });

    $(input).datepicker({
      dateFormat: "yy-mm-dd",
      onSelect: (date) => {
        hiddenInput.value = date;
      }
    });
  }

  mostrarCalendario() {
    $(`#${this.inputId}`).datepicker("show");
  }
}
