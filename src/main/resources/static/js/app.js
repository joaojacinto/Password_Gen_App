const lengthInput  = document.getElementById("lengthInput");
const lengthValue  = document.getElementById("lengthValue");
const lowerInput   = document.getElementById("lowerInput");
const upperInput   = document.getElementById("upperInput");
const digitsInput  = document.getElementById("digitsInput");
const symbolsInput = document.getElementById("symbolsInput");
const generateBtn  = document.getElementById("generateBtn");
const passwordBox  = document.getElementById("passwordBox");
const copyBtn      = document.getElementById("copyBtn");
const errorBox     = document.getElementById("errorBox");

const DEFAULT_LENGTH = 16;

function resetLength() {
    lengthInput.value = DEFAULT_LENGTH;
    lengthValue.textContent = DEFAULT_LENGTH;
}

window.addEventListener("pageshow", resetLength);

lengthInput.addEventListener("input", () => {
    lengthValue.textContent = lengthInput.value;
});

generateBtn.addEventListener("click", async () => {
    errorBox.textContent = "";

    const params = new URLSearchParams({
        length:  lengthInput.value,
        lower:   lowerInput.checked,
        upper:   upperInput.checked,
        digits:  digitsInput.checked,
        symbols: symbolsInput.checked
    });

    try {
        const response = await fetch("/api/password?" + params);
        const text = await response.text();

        if (response.ok) {
            passwordBox.value = text;
        } else {
            passwordBox.value = "";
            errorBox.textContent = text;   // message from exception handler
        }
    } catch (error) {
        errorBox.textContent = "Could not reach the server.";
    }
});

copyBtn.addEventListener("click", async () => {
    if (!passwordBox.value) return;
    await navigator.clipboard.writeText(passwordBox.value);
    copyBtn.textContent = "Copied!";
    setTimeout(() => { copyBtn.textContent = "Copy"; }, 1500);
});