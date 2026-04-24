$ErrorActionPreference = "Stop"

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
$backendDir = Join-Path $root "backend"
if (-not (Test-Path $backendDir)) {
  $backendDir = Join-Path $root "BackEnd"
}
if (-not (Test-Path $backendDir)) {
  throw "Could not find backend directory ('backend' or 'BackEnd')."
}

$envFile = Join-Path $root ".env.backend"
if (Test-Path $envFile) {
  Get-Content $envFile | ForEach-Object {
    $line = $_.Trim()
    if ($line -and -not $line.StartsWith("#")) {
      $pair = $line -split "=", 2
      if ($pair.Count -eq 2) {
        [Environment]::SetEnvironmentVariable($pair[0], $pair[1], "Process")
      }
    }
  }
}

if (-not $env:SPRING_DATASOURCE_URL) {
  $env:SPRING_DATASOURCE_URL = "jdbc:postgresql://localhost:5433/glow_business_board"
}
if (-not $env:SPRING_DATASOURCE_USERNAME) {
  $env:SPRING_DATASOURCE_USERNAME = "glow_user"
}
if (-not $env:SPRING_DATASOURCE_PASSWORD) {
  $env:SPRING_DATASOURCE_PASSWORD = "glow_pass_123"
}

Write-Host "Using backend dir: $backendDir"
Write-Host "Using datasource URL: $($env:SPRING_DATASOURCE_URL)"
Write-Host "Using datasource user: $($env:SPRING_DATASOURCE_USERNAME)"

Set-Location $backendDir
& .\mvnw.cmd spring-boot:run
