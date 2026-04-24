$ErrorActionPreference = "Stop"

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $root

if (-not (Get-Command npm -ErrorAction SilentlyContinue)) {
  throw "npm is not available in PATH. Please install Node.js and reopen terminal."
}

if (-not (Test-Path (Join-Path $root "package.json"))) {
  throw "package.json not found in project root: $root"
}

Write-Host "Starting frontend dev server from: $root"
& npm run dev
