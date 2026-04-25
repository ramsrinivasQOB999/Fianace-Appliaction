// @lovable.dev/vite-tanstack-config already includes the following — do NOT add them manually
// or the app will break with duplicate plugins:
//   - tanstackStart, viteReact, tailwindcss, tsConfigPaths, cloudflare (build-only),
//     componentTagger (dev-only), VITE_* env injection, @ path alias, React/TanStack dedupe,
//     error logger plugins, and sandbox detection (port/host/strictPort).
// You can pass additional config via defineConfig({ vite: { ... } }) if needed.
import { defineConfig } from "@lovable.dev/vite-tanstack-config";

export default defineConfig({
  // We deploy to Vercel as a SPA, not Cloudflare.
  // Disable the Cloudflare build plugin so the output is a plain static client bundle.
  cloudflare: false,

  // Build TanStack Start as a static SPA (prerenders "/" -> dist/client/index.html).
  // Vercel then serves dist/client/ with a catch-all rewrite back to /index.html.
  tanstackStart: {
    spa: {
      enabled: true,
    },
  },

  vite: {
    server: {
      port: 5173,
      strictPort: false,
    },
  },
});
